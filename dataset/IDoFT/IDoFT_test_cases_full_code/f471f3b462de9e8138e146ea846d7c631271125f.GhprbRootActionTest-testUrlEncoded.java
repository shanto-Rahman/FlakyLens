@Test public void testUrlEncoded() throws Exception {
  FreeStyleProject project=jenkinsRule.createFreeStyleProject("testUrlEncoded");
  doReturn(project).when(trigger).getActualProject();
  doReturn(true).when(trigger).getUseGitHubHooks();
  given(commitPointer.getSha()).willReturn("sha1");
  GhprbTestUtil.setupGhprbTriggerDescriptor(null);
  project.addProperty(new GithubProjectProperty("https://github.com/user/dropwizard"));
  given(ghPullRequest.getId()).willReturn(prId);
  given(ghPullRequest.getNumber()).willReturn(prId);
  given(ghRepository.getPullRequest(prId)).willReturn(ghPullRequest);
  Ghprb ghprb=spy(new Ghprb(trigger));
  doReturn(ghprbGitHub).when(ghprb).getGitHub();
  doReturn(true).when(ghprb).isAdmin(Mockito.any(GHUser.class));
  trigger.start(project,true);
  trigger.setHelper(ghprb);
  project.addTrigger(trigger);
  GitSCM scm=GhprbTestUtil.provideGitSCM();
  project.setScm(scm);
  GhprbTestUtil.triggerRunAndWait(10,trigger,project);
  assertThat(project.getBuilds().toArray().length).isEqualTo(0);
  BufferedReader br=new BufferedReader(new StringReader("payload=" + URLEncoder.encode(GhprbTestUtil.PAYLOAD,"UTF-8")));
  given(req.getContentType()).willReturn("application/x-www-form-urlencoded");
  given(req.getParameter("payload")).willReturn(GhprbTestUtil.PAYLOAD);
  given(req.getHeader("X-GitHub-Event")).willReturn("issue_comment");
  given(req.getReader()).willReturn(br);
  given(req.getCharacterEncoding()).willReturn("UTF-8");
  StringReader brTest=new StringReader(GhprbTestUtil.PAYLOAD);
  IssueComment issueComment=spy(GitHub.connectAnonymously().parseEventPayload(brTest,IssueComment.class));
  brTest.close();
  GHIssueComment ghIssueComment=spy(issueComment.getComment());
  Mockito.when(issueComment.getComment()).thenReturn(ghIssueComment);
  Mockito.doReturn(ghUser).when(ghIssueComment).getUser();
  given(trigger.getGitHub().parseEventPayload(Mockito.any(Reader.class),Mockito.eq(IssueComment.class))).willReturn(issueComment);
  GhprbRootAction ra=new GhprbRootAction();
  ra.doIndex(req,null);
  int count=0;
  while (count < 5 && project.getBuilds().toArray().length == 0) {
    GhprbTestUtil.waitForBuildsToFinish(project);
    Thread.sleep(50);
    count=count + 1;
  }
  assertThat(project.getBuilds().toArray().length).isEqualTo(1);
}

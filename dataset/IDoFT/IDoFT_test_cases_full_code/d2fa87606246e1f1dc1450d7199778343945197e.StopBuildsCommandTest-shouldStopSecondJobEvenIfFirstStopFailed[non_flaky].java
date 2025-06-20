@Test public void shouldStopSecondJobEvenIfFirstStopFailed() throws Exception {
  final FreeStyleProject project=createLongRunningProject(TEST_JOB_NAME_2);
  final FreeStyleProject restrictedProject=createLongRunningProject(TEST_JOB_NAME);
  j.jenkins.setSecurityRealm(j.createDummySecurityRealm());
  j.jenkins.setAuthorizationStrategy(new MockAuthorizationStrategy().grant(Jenkins.READ).everywhere().toEveryone().grant(Item.READ).onItems(restrictedProject,project).toEveryone().grant(Item.CANCEL).onItems(restrictedProject).toAuthenticated().grant(Item.CANCEL).onItems(project).toEveryone());
  restrictedProject.scheduleBuild2(0).waitForStart();
  project.scheduleBuild2(0).waitForStart();
  final String stdout=runWith(asList(TEST_JOB_NAME,TEST_JOB_NAME_2)).stdout();
  List<String> testList=Arrays.asList(stdout.split(LN));
  assertThat(testList,contains("Exception occurred while trying to stop build '#1' for job 'jobName'. " + "Exception class: AccessDeniedException3, message: anonymous is missing the Job/Cancel permission","Build '#1' stopped for job 'jobName2'"));
}

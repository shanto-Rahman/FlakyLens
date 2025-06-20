@Deployment(resources="org/activiti/engine/test/api/task/IdentityLinksProcess.bpmn20.xml") public void testEmptyCandidateUserLink(){
assertNotNull(identityLinks);
assertEquals(1,identityLinks.size());
assertEquals("muppets",identityLink.getGroupId());
assertEquals(null,identityLink.getUserId());
assertEquals(IdentityLinkType.CANDIDATE,identityLink.getType());
assertEquals(taskId,identityLink.getTaskId());
assertEquals(0,taskService.getIdentityLinksForTask(taskId).size());
}
@Deployment(resources="org/activiti/engine/test/api/task/IdentityLinksProcess.bpmn20.xml") public void testCandidateUserLink(){
assertNull(identityLink.getGroupId());
assertEquals("kermit",identityLink.getUserId());
assertEquals(IdentityLinkType.CANDIDATE,identityLink.getType());
assertEquals(taskId,identityLink.getTaskId());
assertEquals(1,identityLinks.size());
assertEquals(0,taskService.getIdentityLinksForTask(taskId).size());
}
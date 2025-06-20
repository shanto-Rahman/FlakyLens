@Deployment(resources="org/activiti/engine/test/api/task/IdentityLinksProcess.bpmn20.xml") public void testCustomTypeUserLink(){
assertNull(identityLink.getGroupId());
assertEquals("kermit",identityLink.getUserId());
assertEquals("interestee",identityLink.getType());
assertEquals(taskId,identityLink.getTaskId());
assertEquals(1,identityLinks.size());
assertEquals(0,taskService.getIdentityLinksForTask(taskId).size());
}
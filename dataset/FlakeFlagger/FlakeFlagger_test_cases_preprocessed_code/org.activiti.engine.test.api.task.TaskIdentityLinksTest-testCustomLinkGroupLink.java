@Deployment(resources="org/activiti/engine/test/api/task/IdentityLinksProcess.bpmn20.xml") public void testCustomLinkGroupLink(){
assertEquals("muppets",identityLink.getGroupId());
assertNull("kermit",identityLink.getUserId());
assertEquals("playing",identityLink.getType());
assertEquals(taskId,identityLink.getTaskId());
assertEquals(1,identityLinks.size());
assertEquals(0,taskService.getIdentityLinksForTask(taskId).size());
}
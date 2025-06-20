@Deployment(resources="org/activiti/engine/test/api/runtime/IdentityLinksProcess.bpmn20.xml") public void testCustomLinkGroupLink(){
assertEquals("muppets",identityLink.getGroupId());
assertNull("kermit",identityLink.getUserId());
assertEquals("playing",identityLink.getType());
assertEquals(processInstanceId,identityLink.getProcessInstanceId());
assertEquals(1,identityLinks.size());
assertEquals(0,runtimeService.getIdentityLinksForProcessInstance(processInstanceId).size());
}
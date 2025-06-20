@Deployment(resources="org/activiti/engine/test/api/runtime/IdentityLinksProcess.bpmn20.xml") public void testCustomTypeUserLink(){
assertNull(identityLink.getGroupId());
assertEquals("kermit",identityLink.getUserId());
assertEquals("interestee",identityLink.getType());
assertEquals(processInstanceId,identityLink.getProcessInstanceId());
assertEquals(1,identityLinks.size());
assertEquals(0,runtimeService.getIdentityLinksForProcessInstance(processInstanceId).size());
}
@Deployment(resources="org/activiti/engine/test/api/runtime/IdentityLinksProcess.bpmn20.xml") public void testParticipantUserLink(){
assertNull(identityLink.getGroupId());
assertEquals("kermit",identityLink.getUserId());
assertEquals(IdentityLinkType.PARTICIPANT,identityLink.getType());
assertEquals(processInstanceId,identityLink.getProcessInstanceId());
assertEquals(1,identityLinks.size());
assertEquals(0,runtimeService.getIdentityLinksForProcessInstance(processInstanceId).size());
}
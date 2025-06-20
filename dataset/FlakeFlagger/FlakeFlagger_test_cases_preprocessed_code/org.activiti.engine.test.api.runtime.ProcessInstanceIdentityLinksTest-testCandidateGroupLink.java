@Deployment(resources="org/activiti/engine/test/api/runtime/IdentityLinksProcess.bpmn20.xml") public void testCandidateGroupLink(){
assertEquals("muppets",identityLink.getGroupId());
assertNull("kermit",identityLink.getUserId());
assertEquals(IdentityLinkType.PARTICIPANT,identityLink.getType());
assertEquals(processInstanceId,identityLink.getProcessInstanceId());
assertEquals(1,identityLinks.size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(1,processInstanceEvents.size());
assertEquals(Event.ACTION_ADD_GROUP_LINK,processInstanceEvent.getAction());
assertEquals("muppets",processInstanceEventMessageParts.get(0));
assertEquals(IdentityLinkType.PARTICIPANT,processInstanceEventMessageParts.get(1));
assertEquals(2,processInstanceEventMessageParts.size());
}
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(Event.ACTION_DELETE_GROUP_LINK,processIsntanceEvent.getAction());
assertEquals("muppets",processInstanceEventMessageParts.get(0));
assertEquals(IdentityLinkType.PARTICIPANT,processInstanceEventMessageParts.get(1));
assertEquals(2,processInstanceEventMessageParts.size());
assertEquals(2,processInstanceEvents.size());
}
assertEquals(0,runtimeService.getIdentityLinksForProcessInstance(processInstanceId).size());
}
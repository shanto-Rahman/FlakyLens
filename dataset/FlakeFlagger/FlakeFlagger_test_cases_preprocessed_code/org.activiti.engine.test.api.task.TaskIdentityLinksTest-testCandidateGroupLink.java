@Deployment(resources="org/activiti/engine/test/api/task/IdentityLinksProcess.bpmn20.xml") public void testCandidateGroupLink(){
assertEquals("muppets",identityLink.getGroupId());
assertNull("kermit",identityLink.getUserId());
assertEquals(IdentityLinkType.CANDIDATE,identityLink.getType());
assertEquals(taskId,identityLink.getTaskId());
assertEquals(1,identityLinks.size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(1,taskEvents.size());
assertEquals(Event.ACTION_ADD_GROUP_LINK,taskEvent.getAction());
assertEquals("muppets",taskEventMessageParts.get(0));
assertEquals(IdentityLinkType.CANDIDATE,taskEventMessageParts.get(1));
assertEquals(2,taskEventMessageParts.size());
}
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(Event.ACTION_DELETE_GROUP_LINK,taskEvent.getAction());
assertEquals("muppets",taskEventMessageParts.get(0));
assertEquals(IdentityLinkType.CANDIDATE,taskEventMessageParts.get(1));
assertEquals(2,taskEventMessageParts.size());
assertEquals(2,taskEvents.size());
}
assertEquals(0,taskService.getIdentityLinksForTask(taskId).size());
}
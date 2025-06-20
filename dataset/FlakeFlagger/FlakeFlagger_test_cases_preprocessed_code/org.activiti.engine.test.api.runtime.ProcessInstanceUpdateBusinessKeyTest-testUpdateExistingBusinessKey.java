@Deployment public void testUpdateExistingBusinessKey(){
assertEquals("testKey",processInstance.getBusinessKey());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals("testKey",historicProcessInstance.getBusinessKey());
}
assertEquals("newKey",processInstance.getBusinessKey());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals("newKey",historicProcessInstance.getBusinessKey());
}
}
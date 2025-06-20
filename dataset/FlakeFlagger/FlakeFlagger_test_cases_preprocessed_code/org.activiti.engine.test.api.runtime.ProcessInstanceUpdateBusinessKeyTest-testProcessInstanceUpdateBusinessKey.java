@Deployment public void testProcessInstanceUpdateBusinessKey(){
assertEquals("bzKey",processInstance.getBusinessKey());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals("bzKey",historicProcessInstance.getBusinessKey());
}
}
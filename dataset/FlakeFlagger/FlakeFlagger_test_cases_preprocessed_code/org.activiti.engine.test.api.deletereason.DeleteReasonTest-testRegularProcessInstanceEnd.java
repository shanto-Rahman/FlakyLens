@Deployment public void testRegularProcessInstanceEnd(){
assertEquals(0L,runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertNull(historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult().getDeleteReason());
assertEquals(5,historicTaskInstances.size());
assertNull(historicTaskInstance.getDeleteReason());
}
}
@Deployment public void testDeleteProcessInstanceWithReceiveTask(){
assertNotNull(execution);
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(DeleteReason.PROCESS_INSTANCE_DELETED,historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult().getDeleteReason());
assertEquals(1,historicActivityInstances.size());
assertEquals(DeleteReason.PROCESS_INSTANCE_DELETED,historicActivityInstance.getDeleteReason());
}
assertNotNull(executionA);
assertNotNull(executionB);
assertNotNull(executionC);
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(DeleteReason.PROCESS_INSTANCE_DELETED,historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult().getDeleteReason());
}
}
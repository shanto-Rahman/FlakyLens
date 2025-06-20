@Deployment public void testDeleteProcessInstanceWithCustomDeleteReason(){
assertEquals("A",task.getName());
assertEquals(0L,runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(customDeleteReason,historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult().getDeleteReason());
assertEquals(4,historicTaskInstances.size());
if (historicTaskInstance.getName().equals("A")) {
assertNull(historicTaskInstance.getDeleteReason());
assertEquals(customDeleteReason,historicTaskInstance.getDeleteReason());
}
}
}
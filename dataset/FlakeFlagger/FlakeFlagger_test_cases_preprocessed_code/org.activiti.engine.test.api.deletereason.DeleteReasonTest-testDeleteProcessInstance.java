@Deployment public void testDeleteProcessInstance(){
assertEquals("A",task.getName());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(DeleteReason.PROCESS_INSTANCE_DELETED,historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult().getDeleteReason());
assertEquals(4,historicTaskInstances.size());
if (historicTaskInstance.getName().equals("A")) {
assertNull(historicTaskInstance.getDeleteReason());
assertEquals(DeleteReason.PROCESS_INSTANCE_DELETED,historicTaskInstance.getDeleteReason());
}
}
}
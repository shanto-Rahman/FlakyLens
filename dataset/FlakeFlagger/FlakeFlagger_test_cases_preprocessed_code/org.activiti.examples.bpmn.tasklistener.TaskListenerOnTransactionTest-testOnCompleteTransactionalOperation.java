@Deployment public void testOnCompleteTransactionalOperation(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,historicProcessInstances.size());
assertEquals("transactionDependentTaskListenerProcess",historicProcessInstances.get(0).getProcessDefinitionKey());
}
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,historicProcessInstances.size());
assertEquals("secondTransactionDependentTaskListenerProcess",historicProcessInstances.get(0).getProcessDefinitionKey());
}
assertEquals(1,currentTasks.size());
assertEquals("usertask1",currentTasks.get(0).getTaskId());
assertEquals("User Task 1",currentTasks.get(0).getTaskName());
}
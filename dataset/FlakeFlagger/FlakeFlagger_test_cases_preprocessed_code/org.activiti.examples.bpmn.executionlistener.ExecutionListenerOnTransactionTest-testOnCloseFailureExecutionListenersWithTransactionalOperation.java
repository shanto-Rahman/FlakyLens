@Deployment public void testOnCloseFailureExecutionListenersWithTransactionalOperation(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,historicProcessInstances.size());
assertEquals("transactionDependentExecutionListenerProcess",historicProcessInstances.get(0).getProcessDefinitionKey());
}
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,historicProcessInstances.size());
assertEquals("secondTransactionDependentExecutionListenerProcess",historicProcessInstances.get(0).getProcessDefinitionKey());
}
assertEquals(1,currentActivities.size());
assertEquals("serviceTask1",currentActivities.get(0).getActivityId());
assertEquals("Service Task 1",currentActivities.get(0).getActivityName());
}
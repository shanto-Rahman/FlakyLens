@Test @Deployment public void testOneTaskProcess(){
assertEquals(2,executionList.size());
if (execution.getId().equals(execution.getProcessInstanceId())) {
assertNull(execution.getActivityId());
assertTrue(execution.getId().equals(execution.getProcessInstanceId()) == false);
assertEquals("theTask",execution.getActivityId());
}
assertNotNull(rootProcessInstance);
assertNotNull(childExecution);
assertEquals(childExecution.getId(),task.getExecutionId());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(3,historicActivities.size());
assertEquals(childExecution.getId(),historicActivityInstance.getExecutionId());
assertEquals(0,activityIds.size());
}
}
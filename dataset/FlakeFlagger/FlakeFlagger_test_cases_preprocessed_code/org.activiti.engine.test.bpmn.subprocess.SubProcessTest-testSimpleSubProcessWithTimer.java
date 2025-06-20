@Deployment public void testSimpleSubProcessWithTimer(){
assertEquals("Task in subprocess",subProcessTask.getName());
assertEquals(1,managementService.createTimerJobQuery().count());
assertEquals("Fix escalated problem",escalationTask.getName());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicTaskInstance.getEndTime());
assertNotNull(historicActivityInstance.getEndTime());
}
}
@Deployment public void testRepeatWithEnd() throws Throwable {
assertEquals(1,tasks.size());
assertEquals("Task A",task.getName());
assertEquals(1,jobs.size());
assertEquals(0,managementService.createJobQuery().list().size());
assertEquals(1,jobs.size());
assertEquals(0,managementService.createJobQuery().list().size());
assertEquals(1,jobs.size());
assertEquals(0,jobs.size());
assertEquals(0,jobs.size());
assertEquals("Task B",task.getName());
assertEquals(1,tasks.size());
assertEquals(0,jobs.size());
assertEquals(0,jobs.size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicInstance.getEndTime());
}
assertEquals(0,processInstances.size());
assertEquals(0,jobs.size());
assertEquals(0,jobs.size());
assertEquals(0,tasks.size());
}
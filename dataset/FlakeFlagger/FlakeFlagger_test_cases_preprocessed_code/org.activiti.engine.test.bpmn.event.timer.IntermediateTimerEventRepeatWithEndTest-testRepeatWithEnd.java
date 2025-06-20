@Deployment public void testRepeatWithEnd() throws Throwable {
assertEquals(1,tasks.size());
assertEquals(1,tasks.size());
assertEquals("Task A",task.getName());
assertNotNull(timerJob);
assertEquals(timerJob.getId(),timerJobAfter.getId());
assertEquals(0,jobs.size());
assertEquals(1,tasks.size());
assertEquals("Task C",task.getName());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicInstance.getEndTime());
}
assertEquals(0,processInstances.size());
assertEquals(0,jobs.size());
assertEquals(0,tasks.size());
}
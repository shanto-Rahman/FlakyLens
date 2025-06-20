@Test public void testQueryByAssigneeLike(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(task);
assertEquals(task1.getId(),task.getId());
assertNotNull(task);
assertEquals(task2.getId(),task.getId());
}
}
@Test public void testQueryByTaskDeleteReasonLike(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicTask);
assertEquals(task5.getId(),historicTask.getId());
assertNotNull(historicTask);
assertEquals(task6.getId(),historicTask.getId());
assertNotNull(historicTask);
assertEquals(task5.getId(),historicTask.getId());
assertNotNull(historicTask);
assertEquals(task6.getId(),historicTask.getId());
}
}
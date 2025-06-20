@Test public void testQueryByTaskDescriptionLikeIgnoreCase(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(2,list.size());
assertTrue(taskIds.contains(task1.getId()));
assertTrue(taskIds.contains(task3.getId()));
assertEquals(2,list.size());
assertTrue(taskIds.contains(task2.getId()));
assertTrue(taskIds.contains(task4.getId()));
assertEquals(2,list.size());
assertTrue(taskIds.contains(task1.getId()));
assertTrue(taskIds.contains(task3.getId()));
assertEquals(2,list.size());
assertTrue(taskIds.contains(task2.getId()));
assertTrue(taskIds.contains(task4.getId()));
}
}
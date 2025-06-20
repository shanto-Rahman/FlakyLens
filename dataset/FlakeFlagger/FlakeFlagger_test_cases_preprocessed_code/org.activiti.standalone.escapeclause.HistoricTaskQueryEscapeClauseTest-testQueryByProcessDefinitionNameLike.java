@Test public void testQueryByProcessDefinitionNameLike(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(4,list.size());
assertTrue(taskIds.contains(task1.getId()));
assertTrue(taskIds.contains(task2.getId()));
assertTrue(taskIds.contains(task3.getId()));
assertTrue(taskIds.contains(task4.getId()));
assertEquals(4,list.size());
assertTrue(taskIds.contains(task1.getId()));
assertTrue(taskIds.contains(task2.getId()));
assertTrue(taskIds.contains(task3.getId()));
assertTrue(taskIds.contains(task4.getId()));
}
}
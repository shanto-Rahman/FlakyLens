@Test public void testQueryByProcessDefinitionKeyLike(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNull(task);
assertNull(task);
assertNull(task);
assertNull(task);
}
}
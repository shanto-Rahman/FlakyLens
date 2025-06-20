@Test public void testQueryByProcessDefinitionKeyLikeIgnoreCase(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNull(task);
assertNull(task);
assertNull(task);
assertNull(task);
}
}
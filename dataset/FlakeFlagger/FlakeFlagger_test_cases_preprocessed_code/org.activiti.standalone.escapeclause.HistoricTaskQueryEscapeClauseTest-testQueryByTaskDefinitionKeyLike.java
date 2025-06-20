@Test public void testQueryByTaskDefinitionKeyLike(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(0,list.size());
assertEquals(0,list.size());
assertEquals(0,list.size());
assertEquals(0,list.size());
}
}
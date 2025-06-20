@Test public void testQueryByProcessKeyNotIn(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(2,query.list().size());
assertEquals(2,query.list().size());
assertEquals(2,query.list().size());
assertEquals(2,query.list().size());
assertEquals(0,query.list().size());
assertEquals(0,query.list().size());
assertEquals(0,query.list().size());
assertEquals(0,query.list().size());
assertEquals(2,query.list().size());
assertEquals(2,query.list().size());
assertEquals(2,query.list().size());
assertEquals(2,query.list().size());
assertEquals(0,query.list().size());
assertEquals(0,query.list().size());
assertEquals(0,query.list().size());
assertEquals(0,query.list().size());
}
}
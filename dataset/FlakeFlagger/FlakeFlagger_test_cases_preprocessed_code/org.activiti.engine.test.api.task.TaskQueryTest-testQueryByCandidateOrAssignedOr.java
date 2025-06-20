public void testQueryByCandidateOrAssignedOr(){
assertEquals(11,query.count());
assertEquals(11,tasks.size());
assertEquals(11,query.count());
assertEquals(11,tasks.size());
assertEquals(3,query.count());
assertEquals(3,query.list().size());
assertEquals(12,query.count());
assertEquals(12,tasks.size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
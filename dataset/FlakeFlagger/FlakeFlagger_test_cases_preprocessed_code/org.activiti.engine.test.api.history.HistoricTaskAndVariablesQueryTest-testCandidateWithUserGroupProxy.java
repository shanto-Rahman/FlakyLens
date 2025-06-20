@Deployment public void testCandidateWithUserGroupProxy(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(3,tasks.size());
assertEquals(0,tasks.size());
assertEquals(1,tasks.size());
assertEquals(3,tasks.size());
assertEquals(1,tasks.size());
assertEquals(3,tasks.size());
assertEquals(0,tasks.size());
assertEquals(1,tasks.size());
assertEquals(3,tasks.size());
assertEquals(1,tasks.size());
assertEquals(0,tasks.size());
}
}
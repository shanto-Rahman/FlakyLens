@Deployment public void testAddCommentToProcessInstance(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,comments.size());
assertEquals(1,commentsByType.size());
assertEquals(0,commentsByType.size());
}
}
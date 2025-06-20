@Deployment public void testEmptyCollectionOnSequentialEmbeddedSubprocess(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(1L,historyService.createHistoricProcessInstanceQuery().finished().count());//RW
}
}
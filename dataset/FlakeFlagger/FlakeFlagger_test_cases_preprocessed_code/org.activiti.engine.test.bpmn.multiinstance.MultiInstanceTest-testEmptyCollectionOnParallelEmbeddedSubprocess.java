@Deployment public void testEmptyCollectionOnParallelEmbeddedSubprocess(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(1L,historyService.createHistoricProcessInstanceQuery().finished().count());//RW
}
}
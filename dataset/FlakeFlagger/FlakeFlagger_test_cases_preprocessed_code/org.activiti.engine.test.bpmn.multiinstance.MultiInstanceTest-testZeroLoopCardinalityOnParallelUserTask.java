@Deployment public void testZeroLoopCardinalityOnParallelUserTask(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(1L,historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).finished().count());//RW
}
}
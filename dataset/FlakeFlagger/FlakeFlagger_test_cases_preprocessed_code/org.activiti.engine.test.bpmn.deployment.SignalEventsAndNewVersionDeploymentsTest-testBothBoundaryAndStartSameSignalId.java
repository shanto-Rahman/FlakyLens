public void testBothBoundaryAndStartSameSignalId(){
assertEquals(0,runtimeService.createExecutionQuery().count());
assertEquals(2,getAllEventSubscriptions().size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(9,historyService.createHistoricProcessInstanceQuery().count());
}
assertEquals(2,getAllEventSubscriptions().size());
assertEquals(2,runtimeService.createProcessInstanceQuery().count());
}
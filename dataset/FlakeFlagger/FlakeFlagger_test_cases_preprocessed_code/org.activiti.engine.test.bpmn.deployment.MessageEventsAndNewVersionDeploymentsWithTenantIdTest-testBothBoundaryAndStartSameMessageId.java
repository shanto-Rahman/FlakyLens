public void testBothBoundaryAndStartSameMessageId(){
assertEquals(1,getAllEventSubscriptions().size());
assertEquals(0,runtimeService.createExecutionQuery().count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(9,historyService.createHistoricProcessInstanceQuery().count());
}
assertEquals(10,getAllEventSubscriptions().size());
assertEquals(10,runtimeService.createProcessInstanceQuery().count());
fail();
}
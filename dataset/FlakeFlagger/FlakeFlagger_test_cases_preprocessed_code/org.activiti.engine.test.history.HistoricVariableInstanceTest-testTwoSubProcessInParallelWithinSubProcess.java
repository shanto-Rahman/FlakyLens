@Deployment public void testTwoSubProcessInParallelWithinSubProcess(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals(2,variables.size());
assertEquals("myVar",historicVariable.getName());
assertEquals("test101112",historicVariable.getTextValue());
assertEquals("myVar1",historicVariable1.getName());
assertEquals("test789",historicVariable1.getTextValue());
assertEquals(18,historyService.createHistoricActivityInstanceQuery().count());
assertEquals(7,historyService.createHistoricDetailQuery().count());
}
}
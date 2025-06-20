@Deployment public void testParallelNoWaitState(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals(1,variables.size());
assertEquals("test456",historicVariable.getTextValue());
assertEquals(7,historyService.createHistoricActivityInstanceQuery().count());
assertEquals(2,historyService.createHistoricDetailQuery().count());
}
}
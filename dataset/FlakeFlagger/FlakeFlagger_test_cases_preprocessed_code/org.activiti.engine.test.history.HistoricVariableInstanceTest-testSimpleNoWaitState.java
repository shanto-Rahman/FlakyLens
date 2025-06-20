@Deployment public void testSimpleNoWaitState(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals(1,variables.size());
assertEquals("test456",historicVariable.getTextValue());
assertEquals(4,historyService.createHistoricActivityInstanceQuery().count());
assertEquals(2,historyService.createHistoricDetailQuery().count());
}
}
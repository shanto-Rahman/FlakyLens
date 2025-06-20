@Deployment public void testSimple(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals("userTask1",userTask.getName());
assertEquals(1,variables.size());
assertEquals("test456",historicVariable.getTextValue());
assertEquals(5,historyService.createHistoricActivityInstanceQuery().count());
assertEquals(3,historyService.createHistoricDetailQuery().count());
}
}
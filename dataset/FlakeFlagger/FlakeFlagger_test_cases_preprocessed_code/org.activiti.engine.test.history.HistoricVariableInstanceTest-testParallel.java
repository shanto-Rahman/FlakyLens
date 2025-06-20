@Deployment public void testParallel(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals("userTask1",userTask.getName());
assertEquals(2,variables.size());
assertEquals("myVar",historicVariable.getName());
assertEquals("test789",historicVariable.getTextValue());
assertEquals("myVar1",historicVariable1.getName());
assertEquals("test456",historicVariable1.getTextValue());
assertEquals(8,historyService.createHistoricActivityInstanceQuery().count());
assertEquals(5,historyService.createHistoricDetailQuery().count());
}
}
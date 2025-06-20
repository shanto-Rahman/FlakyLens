@Deployment(resources={"org/activiti/engine/test/history/oneTaskProcess.bpmn20.xml"}) public void testChangeType(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals("my task",task.getName());
assertEquals("123",getHistoricVariable("firstVar").getValue());
assertEquals("456",getHistoricVariable("firstVar").getValue());
assertEquals("789",getHistoricVariable("firstVar").getValue());
assertEquals("123",getHistoricVariable("secondVar").getValue());
assertEquals(456,getHistoricVariable("secondVar").getValue());
assertEquals("789",getHistoricVariable("secondVar").getValue());
}
}
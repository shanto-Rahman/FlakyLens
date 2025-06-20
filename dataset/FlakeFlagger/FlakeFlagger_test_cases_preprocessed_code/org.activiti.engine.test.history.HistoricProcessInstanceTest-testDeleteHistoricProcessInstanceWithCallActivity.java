@Deployment(resources={"org/activiti/engine/test/history/HistoricProcessInstanceTest.testDeleteHistoricProcessInstanceWithCallActivity.bpmn20.xml","org/activiti/engine/test/history/HistoricProcessInstanceTest.testDeleteHistoricProcessInstanceWithCallActivity-subprocess.bpmn20.xml"}) public void testDeleteHistoricProcessInstanceWithCallActivity(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(2L,historyService.createHistoricProcessInstanceQuery().count());
assertEquals(0L,historyService.createHistoricProcessInstanceQuery().count());
}
}
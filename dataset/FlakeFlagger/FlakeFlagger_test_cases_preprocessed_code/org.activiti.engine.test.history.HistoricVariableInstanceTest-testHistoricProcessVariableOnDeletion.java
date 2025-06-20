@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testHistoricProcessVariableOnDeletion(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals(1,historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getId()).variableValueEquals("testVar","Hallo Christian").count());
}
}
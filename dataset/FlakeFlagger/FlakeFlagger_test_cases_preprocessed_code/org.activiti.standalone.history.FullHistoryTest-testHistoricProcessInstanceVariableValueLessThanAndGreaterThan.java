@Deployment(resources={"org/activiti/standalone/history/FullHistoryTest.testHistoricProcessInstanceVariableValueEquals.bpmn20.xml"}) public void testHistoricProcessInstanceVariableValueLessThanAndGreaterThan() throws Exception {
assertEquals(1,historyService.createHistoricDetailQuery().variableUpdates().processInstanceId(processInstance.getId()).count());
assertEquals(0,historyService.createHistoricProcessInstanceQuery().variableValueGreaterThan("longVar",12345L).count());
}
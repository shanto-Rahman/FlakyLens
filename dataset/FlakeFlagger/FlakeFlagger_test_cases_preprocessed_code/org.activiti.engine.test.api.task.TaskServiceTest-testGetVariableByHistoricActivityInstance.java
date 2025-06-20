@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testGetVariableByHistoricActivityInstance(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertNotNull(processInstance);
assertNotNull(historicActivitiInstance);
assertEquals(2,resultSet.size());
assertEquals("variable1",((HistoricVariableUpdate)resultSet.get(0)).getVariableName());
assertEquals("value1",((HistoricVariableUpdate)resultSet.get(0)).getValue());
assertEquals("variable1",((HistoricVariableUpdate)resultSet.get(1)).getVariableName());
assertEquals("value2",((HistoricVariableUpdate)resultSet.get(1)).getValue());
}
}
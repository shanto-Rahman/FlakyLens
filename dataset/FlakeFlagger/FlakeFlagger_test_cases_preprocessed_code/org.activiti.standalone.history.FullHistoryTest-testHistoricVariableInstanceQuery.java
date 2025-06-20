@Deployment(resources="org/activiti/standalone/history/FullHistoryTest.testVariableUpdates.bpmn20.xml") public void testHistoricVariableInstanceQuery(){
assertEquals(1,historyService.createHistoricVariableInstanceQuery().variableName("process").count());
assertEquals(1,historyService.createHistoricVariableInstanceQuery().variableValueEquals("process","one").count());
assertEquals(2,historyService.createHistoricVariableInstanceQuery().variableName("process").count());
assertEquals(1,historyService.createHistoricVariableInstanceQuery().variableValueEquals("process","one").count());
assertEquals(1,historyService.createHistoricVariableInstanceQuery().variableValueEquals("process","two").count());
assertEquals("process",historicProcessVariable.getVariableName());
assertEquals("one",historicProcessVariable.getValue());
assertEquals(1,historyService.createHistoricVariableInstanceQuery().variableName("long").count());
assertEquals(1,historyService.createHistoricVariableInstanceQuery().variableValueEquals("long",1000l).count());
assertEquals(1,historyService.createHistoricVariableInstanceQuery().variableName("double").count());
assertEquals(1,historyService.createHistoricVariableInstanceQuery().variableValueEquals("double",25.43d).count());
}
@Deployment(resources={"org/activiti/engine/test/api/runtime/variableScope.bpmn20.xml"}) public void testHistoricVariableQueryByTaskIdsForScope(){
if (!processInstance.getId().equals(execution.getId())) {
}
assertEquals(historicVariableInstances.size(),2);
assertEquals(historicVariableInstances.get(0).getVariableName(),"taskVar");
assertEquals(historicVariableInstances.get(0).getValue(),"taskVar");
assertEquals(historicVariableInstances.get(1).getVariableName(),"taskVar");
assertEquals(historicVariableInstances.get(1).getValue(),"taskVar");
}
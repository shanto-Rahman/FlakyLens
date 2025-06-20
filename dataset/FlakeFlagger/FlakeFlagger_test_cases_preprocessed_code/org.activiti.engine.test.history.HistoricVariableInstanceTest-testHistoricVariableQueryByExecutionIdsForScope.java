@Deployment(resources={"org/activiti/engine/test/api/runtime/variableScope.bpmn20.xml"}) public void testHistoricVariableQueryByExecutionIdsForScope(){
if (!processInstance.getId().equals(execution.getId())) {
}
assertEquals(historicVariableInstances.size(),1);
assertEquals(historicVariableInstances.get(0).getVariableName(),"processVar");
assertEquals(historicVariableInstances.get(0).getValue(),"processVar");
assertEquals(historicVariableInstances.size(),2);
assertEquals(historicVariableInstances.get(0).getVariableName(),"executionVar");
assertEquals(historicVariableInstances.get(0).getValue(),"executionVar");
assertEquals(historicVariableInstances.get(1).getVariableName(),"executionVar");
assertEquals(historicVariableInstances.get(1).getValue(),"executionVar");
}
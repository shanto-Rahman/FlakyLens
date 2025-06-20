@Deployment(resources={"org/activiti/engine/test/api/runtime/variableScope.bpmn20.xml"}) public void testGetVariablesByExecutionIdsForScope(){
if (!processInstance.getId().equals(execution.getId())) {
}
assertEquals(executionVariableInstances.size(),2);
assertEquals(executionVariableInstances.get(0).getName(),"executionVar");
assertEquals(executionVariableInstances.get(0).getValue(),"executionVar");
assertEquals(executionVariableInstances.get(1).getName(),"executionVar");
assertEquals(executionVariableInstances.get(1).getValue(),"executionVar");
assertEquals(executionVariableInstances.size(),1);
assertEquals(executionVariableInstances.get(0).getName(),"processVar");
assertEquals(executionVariableInstances.get(0).getValue(),"processVar");
}
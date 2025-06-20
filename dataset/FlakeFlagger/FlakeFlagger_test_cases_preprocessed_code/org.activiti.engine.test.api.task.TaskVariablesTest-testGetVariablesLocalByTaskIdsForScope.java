@Deployment(resources={"org/activiti/engine/test/api/runtime/variableScope.bpmn20.xml"}) public void testGetVariablesLocalByTaskIdsForScope(){
if (!processInstance.getId().equals(execution.getId())) {
}
assertEquals(variableInstances.size(),2);
assertEquals(variableInstances.get(0).getName(),"taskVar");
assertEquals(variableInstances.get(0).getValue(),"taskVar");
assertEquals(variableInstances.get(1).getName(),"taskVar");
assertEquals(variableInstances.get(1).getValue(),"taskVar");
}
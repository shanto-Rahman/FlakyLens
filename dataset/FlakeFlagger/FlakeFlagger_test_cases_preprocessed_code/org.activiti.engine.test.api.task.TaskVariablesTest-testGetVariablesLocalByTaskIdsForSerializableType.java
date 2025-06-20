@Deployment(resources={"org/activiti/engine/test/api/task/TaskVariablesTest.testTaskExecutionVariables.bpmn20.xml"}) public void testGetVariablesLocalByTaskIdsForSerializableType(){
assertEquals(serializableTypeVar,variables.get(0).getValue());
}
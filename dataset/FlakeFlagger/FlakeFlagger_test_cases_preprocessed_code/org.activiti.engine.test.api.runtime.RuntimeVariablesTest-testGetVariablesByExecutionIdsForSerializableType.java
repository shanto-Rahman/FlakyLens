@Deployment(resources={"org/activiti/engine/test/api/runtime/RuntimeVariablesTest.testGetVariablesByExecutionIds.bpmn20.xml"}) public void testGetVariablesByExecutionIdsForSerializableType(){
assertEquals(serializableTypeVar,variables.get(0).getValue());
}
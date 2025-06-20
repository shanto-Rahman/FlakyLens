@Deployment(resources={"org/activiti/engine/test/api/oneSubProcess.bpmn20.xml"}) public void testRemoveVariableInParentScope(){
assertNull(runtimeService.getVariable(processInstance.getId(),"variable1"));
assertEquals("value2",runtimeService.getVariable(processInstance.getId(),"variable2"));
}
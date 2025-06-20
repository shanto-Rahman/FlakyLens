@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testRemoveVariables(){
assertNull(runtimeService.getVariable(processInstance.getId(),"variable1"));
assertNull(runtimeService.getVariableLocal(processInstance.getId(),"variable1"));
assertNull(runtimeService.getVariable(processInstance.getId(),"variable2"));
assertNull(runtimeService.getVariableLocal(processInstance.getId(),"variable2"));
assertEquals("value3",runtimeService.getVariable(processInstance.getId(),"variable3"));
assertEquals("value3",runtimeService.getVariableLocal(processInstance.getId(),"variable3"));
}
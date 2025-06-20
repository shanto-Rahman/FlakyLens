@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testRemoveVariable(){
assertNull(runtimeService.getVariable(processInstance.getId(),"variable1"));
assertNull(runtimeService.getVariableLocal(processInstance.getId(),"variable1"));
assertEquals("value2",runtimeService.getVariable(processInstance.getId(),"variable2"));
}
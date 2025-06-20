@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testSetVariables(){
assertEquals("value1",runtimeService.getVariable(processInstance.getId(),"variable1"));
assertEquals("value2",runtimeService.getVariable(processInstance.getId(),"variable2"));
}
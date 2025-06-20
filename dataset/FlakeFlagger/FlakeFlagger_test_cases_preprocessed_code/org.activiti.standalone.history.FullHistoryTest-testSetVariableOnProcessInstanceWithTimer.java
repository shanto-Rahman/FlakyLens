@Deployment public void testSetVariableOnProcessInstanceWithTimer(){
assertEquals(123456L,runtimeService.getVariable(processInstance.getId(),"myVar"));
}
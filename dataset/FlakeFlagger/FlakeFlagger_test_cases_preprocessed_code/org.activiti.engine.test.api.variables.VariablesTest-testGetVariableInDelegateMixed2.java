@org.activiti.engine.test.Deployment public void testGetVariableInDelegateMixed2(){
assertEquals("1234",(String)runtimeService.getVariable(processInstanceId,"testVar"));
}
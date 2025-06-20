@org.activiti.engine.test.Deployment public void testGetVariableInDelegateMixed(){
assertEquals("test 1 2 3",(String)runtimeService.getVariable(processInstanceId,"testVar"));
assertEquals("Hiya",(String)runtimeService.getVariable(processInstanceId,"testVar2"));
}
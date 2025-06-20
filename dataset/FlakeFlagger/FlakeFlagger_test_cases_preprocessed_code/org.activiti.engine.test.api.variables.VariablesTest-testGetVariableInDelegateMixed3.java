@org.activiti.engine.test.Deployment public void testGetVariableInDelegateMixed3(){
assertEquals("one-CHANGED",(String)runtimeService.getVariable(processInstanceId,"testVar1"));
assertEquals("two-CHANGED",(String)runtimeService.getVariable(processInstanceId,"testVar2"));
assertNull(runtimeService.getVariable(processInstanceId,"testVar3"));
}
@Deployment public void testSetTransientVariableInServiceTask(){
assertEquals("Hello World!",message);
assertNull(runtimeService.getVariable(processInstance.getId(),"response"));
}
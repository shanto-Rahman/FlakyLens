@Deployment public void testUseTransientVariableInExclusiveGateway(){
assertEquals("responseOk",task.getTaskDefinitionKey());
assertNull(runtimeService.getVariable(processInstance.getId(),"response"));
}
@Deployment public void testTaskCompleteWithTransientVariables(){
assertEquals("My Task",task.getName());
assertEquals("Hello WorldABC123",combinedVar);
assertNotNull(runtimeService.getVariable(processInstance.getId(),"persistentVar1"));
assertNotNull(runtimeService.getVariable(processInstance.getId(),"persistentVar2"));
assertNull(runtimeService.getVariable(processInstance.getId(),"unusedTransientVar"));
assertNull(runtimeService.getVariable(processInstance.getId(),"transientVar"));
assertNull(runtimeService.getVariable(processInstance.getId(),"secondTransientVar"));
assertNull(runtimeService.getVariable(processInstance.getId(),"thirdTransientVar"));
}
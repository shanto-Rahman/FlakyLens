@Deployment public void testCompleteWithTaskLocalParameters(){
assertNull(runtimeService.getVariable(processInstance.getId(),"a"));
assertNull(runtimeService.getVariable(processInstance.getId(),"b"));
assertEquals(new Integer(2),runtimeService.getVariable(processInstance.getId(),"sum"));
}
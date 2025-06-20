@Deployment public void testSetVariableThroughExecutionInScript(){
assertNull(runtimeService.getVariable(pi.getId(),"scriptVar"));
assertEquals("test123",runtimeService.getVariable(pi.getId(),"myVar"));
}
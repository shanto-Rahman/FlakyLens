@Deployment public void testSetScriptResultToProcessVariable(){
assertEquals("hello",runtimeService.getVariable(pi.getId(),"existingProcessVariableName"));
assertEquals(pi.getId(),runtimeService.getVariable(pi.getId(),"newProcessVariableName"));
}
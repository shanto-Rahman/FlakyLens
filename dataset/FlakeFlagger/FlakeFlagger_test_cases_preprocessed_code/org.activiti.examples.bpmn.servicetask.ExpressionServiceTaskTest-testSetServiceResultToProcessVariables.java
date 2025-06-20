@Deployment public void testSetServiceResultToProcessVariables(){
assertEquals("ok",runtimeService.getVariable(pi.getId(),"result"));
}
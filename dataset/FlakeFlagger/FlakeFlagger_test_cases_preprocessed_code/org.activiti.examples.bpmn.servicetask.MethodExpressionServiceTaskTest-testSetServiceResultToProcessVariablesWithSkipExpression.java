@Deployment public void testSetServiceResultToProcessVariablesWithSkipExpression(){
assertEquals("ok",runtimeService.getVariable(pi.getId(),"result"));
assertEquals(null,runtimeService.getVariable(pi2.getId(),"result"));
}
@Deployment public void testExpressionFieldInjectionWithSkipExpression(){
assertEquals("timrek .rM olleH",runtimeService.getVariable(execution.getId(),"var2"));
assertEquals("elam :si redneg ruoY",runtimeService.getVariable(execution.getId(),"var1"));
assertEquals(null,execution2);
}
@Deployment public void testMethodExpressions(){
assertEquals(0,runtimeService.createProcessInstanceQuery().processDefinitionKey("methodExpressionProcess").count());
}
public void testQueryPaging(){
assertEquals(14,runtimeService.createExecutionQuery().count());
assertEquals(4,runtimeService.createExecutionQuery().processDefinitionKey(CONCURRENT_PROCESS_KEY).listPage(0,4).size());//RW
assertEquals(1,runtimeService.createExecutionQuery().processDefinitionKey(CONCURRENT_PROCESS_KEY).listPage(2,1).size());//RW
assertEquals(10,runtimeService.createExecutionQuery().processDefinitionKey(CONCURRENT_PROCESS_KEY).listPage(1,10).size());//RW
assertEquals(12,runtimeService.createExecutionQuery().processDefinitionKey(CONCURRENT_PROCESS_KEY).listPage(0,20).size());//RW
}
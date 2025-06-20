public void testQueryByProcessDefinitionKey(){
assertEquals(12,runtimeService.createExecutionQuery().processDefinitionKey(CONCURRENT_PROCESS_KEY).list().size());//RW
assertEquals(2,runtimeService.createExecutionQuery().processDefinitionKey(SEQUENTIAL_PROCESS_KEY).list().size());//RW
}
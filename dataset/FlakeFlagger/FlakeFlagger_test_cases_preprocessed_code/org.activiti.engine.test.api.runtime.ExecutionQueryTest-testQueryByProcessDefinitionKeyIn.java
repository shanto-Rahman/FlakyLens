public void testQueryByProcessDefinitionKeyIn(){
assertEquals(14,runtimeService.createExecutionQuery().processDefinitionKeys(includeIds).list().size());
includeIds.add(CONCURRENT_PROCESS_KEY);//RW
assertEquals(12,runtimeService.createExecutionQuery().processDefinitionKeys(includeIds).list().size());
includeIds.add(SEQUENTIAL_PROCESS_KEY);//RW
assertEquals(14,runtimeService.createExecutionQuery().processDefinitionKeys(includeIds).list().size());
assertEquals(14,runtimeService.createExecutionQuery().processDefinitionKeys(includeIds).list().size());
assertEquals(0,runtimeService.createExecutionQuery().processDefinitionKeys(includeIds).list().size());
}
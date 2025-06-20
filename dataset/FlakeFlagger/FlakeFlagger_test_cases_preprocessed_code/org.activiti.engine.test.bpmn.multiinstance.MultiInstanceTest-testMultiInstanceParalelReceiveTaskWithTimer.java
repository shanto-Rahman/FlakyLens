@Deployment public void testMultiInstanceParalelReceiveTaskWithTimer(){
assertEquals(3,executions.size());
assertEquals("Task after timer",task.getName());
assertEquals(0,runtimeService.createExecutionQuery().count());//RW
}
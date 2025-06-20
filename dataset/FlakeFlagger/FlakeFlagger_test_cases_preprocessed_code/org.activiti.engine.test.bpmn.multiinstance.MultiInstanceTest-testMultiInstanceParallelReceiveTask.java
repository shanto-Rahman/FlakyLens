@Deployment public void testMultiInstanceParallelReceiveTask(){
assertEquals(4,executions.size());
assertNotNull(task);
assertEquals(0,runtimeService.createExecutionQuery().count());//RW
}
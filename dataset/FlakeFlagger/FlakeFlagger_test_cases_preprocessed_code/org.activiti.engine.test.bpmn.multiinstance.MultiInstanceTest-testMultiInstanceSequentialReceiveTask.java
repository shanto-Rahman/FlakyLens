@Deployment public void testMultiInstanceSequentialReceiveTask(){
assertNotNull(execution);
assertNotNull(task);
assertEquals(0,runtimeService.createExecutionQuery().count());//RW
}
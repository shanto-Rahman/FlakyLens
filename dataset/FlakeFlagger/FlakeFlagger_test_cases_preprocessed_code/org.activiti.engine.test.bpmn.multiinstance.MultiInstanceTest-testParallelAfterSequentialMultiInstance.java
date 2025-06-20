@Deployment public void testParallelAfterSequentialMultiInstance(){
assertEquals(0,runtimeService.createExecutionQuery().count());//RW
}
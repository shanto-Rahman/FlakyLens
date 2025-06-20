@Deployment public void testRollbackAfterError(){
fail("Starting the process instance should throw an error");
assertEquals("Fizz",e.getMessage());
assertEquals(0,runtimeService.createExecutionQuery().count());
}
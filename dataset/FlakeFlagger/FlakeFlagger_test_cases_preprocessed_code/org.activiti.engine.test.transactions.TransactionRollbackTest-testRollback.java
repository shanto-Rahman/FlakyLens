@Deployment public void testRollback(){
fail("Starting the process instance should throw an exception");
assertEquals("Buzzz",e.getMessage());
assertEquals(0,runtimeService.createExecutionQuery().count());
}
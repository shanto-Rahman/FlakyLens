public void testGetVariablesUnexistingExecutionId(){
fail("ActivitiException expected");
assertEquals(Execution.class,ae.getObjectClass());
}
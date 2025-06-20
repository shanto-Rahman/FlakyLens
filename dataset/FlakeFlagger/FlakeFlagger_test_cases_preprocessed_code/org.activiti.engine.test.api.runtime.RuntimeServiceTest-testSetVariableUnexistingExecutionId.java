public void testSetVariableUnexistingExecutionId(){
fail("ActivitiException expected");
assertEquals(Execution.class,ae.getObjectClass());
}
@SuppressWarnings("unchecked") public void testSetVariablesUnexistingExecutionId(){
fail("ActivitiException expected");
assertEquals(Execution.class,ae.getObjectClass());
}
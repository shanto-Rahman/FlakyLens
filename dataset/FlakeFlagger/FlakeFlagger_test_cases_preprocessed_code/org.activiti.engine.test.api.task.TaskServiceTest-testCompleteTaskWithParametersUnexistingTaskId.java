public void testCompleteTaskWithParametersUnexistingTaskId(){
fail("ActivitiException expected");
assertEquals(Task.class,ae.getObjectClass());
}
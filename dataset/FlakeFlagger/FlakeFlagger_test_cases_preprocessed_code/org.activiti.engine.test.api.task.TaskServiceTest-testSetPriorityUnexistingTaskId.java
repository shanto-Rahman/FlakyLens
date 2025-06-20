public void testSetPriorityUnexistingTaskId(){
fail("ActivitiException expected");
assertEquals(Task.class,ae.getObjectClass());
}
public void testSetAssigneeUnexistingTask(){
fail("ActivitiException expected");
assertEquals(Task.class,ae.getObjectClass());
}
public void testClaimUnexistingTaskId(){
fail("ActivitiException expected");
assertEquals(Task.class,ae.getObjectClass());
}
public void testAddCandidateUserUnexistingTask(){
fail("ActivitiException expected");
assertEquals(Task.class,ae.getObjectClass());
}
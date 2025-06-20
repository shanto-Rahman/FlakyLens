public void testAddCandidateGroupUnexistingTask(){
fail("ActivitiException expected");
assertEquals(Task.class,ae.getObjectClass());
}
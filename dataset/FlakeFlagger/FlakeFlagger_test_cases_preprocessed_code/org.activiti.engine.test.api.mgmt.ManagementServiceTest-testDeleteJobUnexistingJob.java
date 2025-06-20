public void testDeleteJobUnexistingJob(){
fail("ActivitiException expected");
assertEquals(Job.class,ae.getObjectClass());
}
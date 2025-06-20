public void testSetJobRetriesUnexistingJobId(){
fail("ActivitiException expected");
assertEquals(Job.class,re.getObjectClass());
}
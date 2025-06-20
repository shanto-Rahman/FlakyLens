public void testExecuteJobUnexistingJob(){
fail("ActivitiException expected");
assertEquals(Job.class,jnfe.getObjectClass());
}
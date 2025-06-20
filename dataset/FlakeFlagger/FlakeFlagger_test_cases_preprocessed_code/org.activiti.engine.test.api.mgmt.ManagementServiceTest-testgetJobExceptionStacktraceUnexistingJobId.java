public void testgetJobExceptionStacktraceUnexistingJobId(){
fail("ActivitiException expected");
assertEquals(Job.class,re.getObjectClass());
}
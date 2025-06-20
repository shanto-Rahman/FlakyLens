@Deployment public void testGetJobExceptionStacktrace(){
assertNotNull("No job found for process instance",timerJob);
fail("RuntimeException from within the script task expected");
assertNotNull(timerJob);
assertNotNull(timerJob.getExceptionMessage());
assertNotNull(exceptionStack);
}
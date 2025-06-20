@Deployment(resources={"org/activiti/engine/test/api/mgmt/ManagementServiceTest.testGetJobExceptionStacktrace.bpmn20.xml"}) public void testSetJobRetries(){
assertNotNull("No job found for process instance",timerJob);
assertEquals(processEngineConfiguration.getAsyncExecutorNumberOfRetries(),timerJob.getRetries());
assertEquals(5,timerJob.getRetries());
assertEquals(duedate,timerJob.getDuedate());
}
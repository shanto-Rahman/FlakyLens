@Test public void assertRegisterJobCompletedWithoutMonitorExecution(){
assertFalse(JobRegistry.getInstance().isJobRunning("test_job"));
}
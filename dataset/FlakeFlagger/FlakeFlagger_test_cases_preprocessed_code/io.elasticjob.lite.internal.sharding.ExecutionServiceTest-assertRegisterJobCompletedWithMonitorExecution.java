@Test public void assertRegisterJobCompletedWithMonitorExecution(){
assertFalse(JobRegistry.getInstance().isJobRunning("test_job"));
}
@Test public void assertRegisterJobBeginWithMonitorExecution(){
assertTrue(JobRegistry.getInstance().isJobRunning("test_job"));
}
@Test public void assertRegisterJobBeginWithoutMonitorExecution(){
assertTrue(JobRegistry.getInstance().isJobRunning("test_job"));
}
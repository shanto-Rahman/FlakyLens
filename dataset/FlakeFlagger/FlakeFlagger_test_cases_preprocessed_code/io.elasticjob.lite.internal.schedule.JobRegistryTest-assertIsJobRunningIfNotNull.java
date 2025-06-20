@Test public void assertIsJobRunningIfNotNull(){
assertTrue(JobRegistry.getInstance().isJobRunning("exist_job_instance"));
}
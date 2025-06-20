@Test public void assertIsNotShutdown(){
assertFalse(JobRegistry.getInstance().isShutdown("test_job_for_job_not_shutdown"));
}
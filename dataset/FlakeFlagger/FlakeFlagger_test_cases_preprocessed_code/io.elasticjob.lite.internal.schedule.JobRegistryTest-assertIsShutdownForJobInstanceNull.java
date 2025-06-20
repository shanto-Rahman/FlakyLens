@Test public void assertIsShutdownForJobInstanceNull(){
assertTrue(JobRegistry.getInstance().isShutdown("test_job_for_job_instance_null"));
}
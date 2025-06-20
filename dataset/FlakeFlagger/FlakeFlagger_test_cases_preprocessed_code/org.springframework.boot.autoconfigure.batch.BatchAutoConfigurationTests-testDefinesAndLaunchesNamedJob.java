@Test public void testDefinesAndLaunchesNamedJob() throws Exception {
assertNotNull(this.context.getBean(JobLauncher.class));
assertNotNull(repository.getLastJobExecution("discreteRegisteredJob",new JobParameters()));
}
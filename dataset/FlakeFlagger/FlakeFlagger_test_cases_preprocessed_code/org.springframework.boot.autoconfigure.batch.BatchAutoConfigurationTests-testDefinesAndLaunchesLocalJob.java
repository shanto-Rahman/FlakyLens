@Test public void testDefinesAndLaunchesLocalJob() throws Exception {
assertNotNull(this.context.getBean(JobLauncher.class));
assertNotNull(this.context.getBean(JobRepository.class).getLastJobExecution("discreteLocalJob",new JobParameters()));
}
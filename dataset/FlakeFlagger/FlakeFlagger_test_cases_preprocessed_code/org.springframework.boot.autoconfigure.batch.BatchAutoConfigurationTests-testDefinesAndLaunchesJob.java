@Test public void testDefinesAndLaunchesJob() throws Exception {
assertNotNull(this.context.getBean(JobLauncher.class));
assertNotNull(this.context.getBean(JobRepository.class).getLastJobExecution("job",new JobParameters()));
}
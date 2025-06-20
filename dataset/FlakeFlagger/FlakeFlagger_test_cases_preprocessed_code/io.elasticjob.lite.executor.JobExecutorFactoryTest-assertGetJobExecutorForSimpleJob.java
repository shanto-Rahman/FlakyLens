@Test public void assertGetJobExecutorForSimpleJob(){
assertThat(JobExecutorFactory.getJobExecutor(new TestSimpleJob(null),jobFacade),instanceOf(SimpleJobExecutor.class));
}
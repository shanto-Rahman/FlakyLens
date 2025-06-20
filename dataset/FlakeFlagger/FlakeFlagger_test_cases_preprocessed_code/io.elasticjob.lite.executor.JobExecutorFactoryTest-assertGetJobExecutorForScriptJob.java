@Test public void assertGetJobExecutorForScriptJob(){
assertThat(JobExecutorFactory.getJobExecutor(null,jobFacade),instanceOf(ScriptJobExecutor.class));
}
@Test public void assertGetJobInstance(){
assertThat(JobRegistry.getInstance().getJobInstance("exist_job_instance"),is(new JobInstance("127.0.0.1@-@0")));
}
@Test public void assertGetRegCenter(){
assertThat(JobRegistry.getInstance().getRegCenter("test_job_scheduler_for_add"),is(regCenter));
}
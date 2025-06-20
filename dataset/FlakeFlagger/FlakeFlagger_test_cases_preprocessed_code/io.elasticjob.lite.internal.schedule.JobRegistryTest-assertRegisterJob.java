@Test public void assertRegisterJob(){
assertThat(JobRegistry.getInstance().getJobScheduleController("test_job_scheduler_for_add"),is(jobScheduleController));
}
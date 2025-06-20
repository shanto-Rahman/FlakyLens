@Test public void assertNewJobExecutionEvent(){
assertThat(actual.getJobName(),is("test_job"));
assertThat(actual.getSource(),is(JobExecutionEvent.ExecutionSource.NORMAL_TRIGGER));
assertThat(actual.getShardingItem(),is(0));
assertNotNull(actual.getHostname());
assertNotNull(actual.getStartTime());
assertNull(actual.getCompleteTime());
assertFalse(actual.isSuccess());
assertThat(actual.getFailureCause(),is(""));
}
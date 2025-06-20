@Test public void assertAddJobStatusTraceEventWhenFailoverWithTaskStagingState() throws SQLException {
assertThat(storage.getJobStatusTraceEvents("fake_failover_task_id").size(),is(0));
assertThat(storage.getJobStatusTraceEvents("fake_failover_task_id").size(),is(1));
}
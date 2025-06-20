@Test public void assertAddJobStatusTraceEventWhenFailoverWithTaskFailedState() throws SQLException {
assertThat(jobStatusTraceEvents.size(),is(2));
assertThat(jobStatusTraceEvent.getOriginalTaskId(),is("original_fake_failed_failover_task_id"));
}
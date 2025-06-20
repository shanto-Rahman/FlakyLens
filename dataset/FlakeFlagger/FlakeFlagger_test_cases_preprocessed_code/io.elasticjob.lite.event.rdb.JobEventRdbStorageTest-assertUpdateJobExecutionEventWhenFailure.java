@Test public void assertUpdateJobExecutionEventWhenFailure() throws SQLException {
assertTrue(storage.addJobExecutionEvent(startEvent));
assertTrue(storage.addJobExecutionEvent(failureEvent));
assertThat(failureEvent.getFailureCause(),startsWith("java.lang.RuntimeException: failure"));
assertTrue(null != failureEvent.getCompleteTime());
}
@Test public void assertUpdateJobExecutionEventWhenFailureAndConflict() throws SQLException {
assertTrue(storage.addJobExecutionEvent(failureEvent));
assertThat(failureEvent.getFailureCause(),startsWith("java.lang.RuntimeException: failure"));
assertFalse(storage.addJobExecutionEvent(startEvent));
}
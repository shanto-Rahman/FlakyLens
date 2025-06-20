@Test public void assertUpdateJobExecutionEventWhenFailureAndMessageExceed() throws SQLException {
assertTrue(storage.addJobExecutionEvent(startEvent));
assertTrue(storage.addJobExecutionEvent(failEvent));
assertThat(failEvent.getFailureCause(),startsWith("java.lang.RuntimeException: failure"));
}
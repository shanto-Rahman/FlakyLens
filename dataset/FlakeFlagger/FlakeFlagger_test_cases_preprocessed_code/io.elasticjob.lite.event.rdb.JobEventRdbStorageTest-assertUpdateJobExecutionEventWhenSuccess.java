@Test public void assertUpdateJobExecutionEventWhenSuccess() throws SQLException {
assertTrue(storage.addJobExecutionEvent(startEvent));
assertTrue(storage.addJobExecutionEvent(successEvent));
}
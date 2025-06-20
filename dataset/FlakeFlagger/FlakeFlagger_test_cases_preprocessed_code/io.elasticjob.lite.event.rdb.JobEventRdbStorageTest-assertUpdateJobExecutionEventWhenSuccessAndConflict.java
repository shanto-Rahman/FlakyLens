@Test public void assertUpdateJobExecutionEventWhenSuccessAndConflict() throws SQLException {
assertTrue(storage.addJobExecutionEvent(successEvent));
assertFalse(storage.addJobExecutionEvent(startEvent));
}
@Test public void appenderShouldFailToStartWithNegativeQueueSize() throws Exception {
assertFalse(instrumentedAppender.isStarted());
assertTrue(mockContext.getLastStatus().getMessage().contains("Queue"));
}
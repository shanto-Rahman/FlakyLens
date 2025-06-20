@Test public void appenderShouldFailToStartWithZeroQueueLength() throws Exception {
assertTrue(instrumentedAppender.isStarted());
assertTrue(instrumentedAppender.lastQueue instanceof SynchronousQueue);
}
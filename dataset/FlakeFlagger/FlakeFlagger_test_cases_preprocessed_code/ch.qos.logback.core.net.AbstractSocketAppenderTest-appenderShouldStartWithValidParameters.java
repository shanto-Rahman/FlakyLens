@Test public void appenderShouldStartWithValidParameters() throws Exception {
assertTrue(instrumentedAppender.isStarted());
assertTrue(instrumentedAppender.lastQueue instanceof ArrayBlockingQueue);
assertEquals(1,instrumentedAppender.lastQueue.remainingCapacity());
}
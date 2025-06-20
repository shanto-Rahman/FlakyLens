@Test public void testAppendWhenNotStarted() throws Exception {
executorService.shutdownNow();
assertTrue(executorService.awaitTermination(DELAY,TimeUnit.MILLISECONDS));
assertTrue(instrumentedAppender.lastQueue.isEmpty());
}
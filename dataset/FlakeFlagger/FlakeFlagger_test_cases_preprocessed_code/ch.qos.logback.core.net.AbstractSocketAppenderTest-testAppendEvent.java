@Test public void testAppendEvent() throws Exception {
executorService.shutdownNow();
assertTrue(executorService.awaitTermination(DELAY,TimeUnit.MILLISECONDS));
assertEquals("some event",instrumentedAppender.lastQueue.poll());
}
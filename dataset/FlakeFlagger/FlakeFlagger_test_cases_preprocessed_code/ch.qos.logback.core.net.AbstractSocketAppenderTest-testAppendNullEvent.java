@Test public void testAppendNullEvent() throws Exception {
assertTrue(instrumentedAppender.lastQueue.isEmpty());
}
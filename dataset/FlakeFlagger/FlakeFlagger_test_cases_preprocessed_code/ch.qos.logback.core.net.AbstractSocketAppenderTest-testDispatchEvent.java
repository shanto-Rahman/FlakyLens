@Test public void testDispatchEvent() throws Exception {
Thread.sleep(shortDelay);
assertTrue(instrumentedAppender.lastQueue.isEmpty());
assertEquals("some event",ois.readObject());
}
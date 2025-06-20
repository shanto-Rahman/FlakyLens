@Test public void testLogEventFromClient() throws Exception {
assertNotNull(rcvdEvent);
assertEquals(event.getLoggerName(),rcvdEvent.getLoggerName());
assertEquals(event.getLevel(),rcvdEvent.getLevel());
assertEquals(event.getMessage(),rcvdEvent.getMessage());
}
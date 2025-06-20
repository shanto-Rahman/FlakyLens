@Test public void testWithEnabledLevel() throws Exception {
assertEquals(event.getLoggerName(),rcvdEvent.getLoggerName());
assertEquals(event.getLevel(),rcvdEvent.getLevel());
assertEquals(event.getMessage(),rcvdEvent.getMessage());
}
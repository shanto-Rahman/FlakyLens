@Test public void testDispatchEventForEnabledLevel() throws Exception {
assertTrue(receiver.awaitConnectorCreated(DELAY));//IT
assertNotNull(rcvdEvent);
assertEquals(event.getLoggerName(),rcvdEvent.getLoggerName());
assertEquals(event.getLevel(),rcvdEvent.getLevel());
assertEquals(event.getMessage(),rcvdEvent.getMessage());
}
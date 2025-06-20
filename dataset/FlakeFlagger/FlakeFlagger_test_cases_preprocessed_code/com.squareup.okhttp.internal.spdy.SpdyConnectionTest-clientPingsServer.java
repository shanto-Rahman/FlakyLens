@Test public void clientPingsServer() throws Exception {
assertTrue(ping.roundTripTime() > 0);
assertTrue(ping.roundTripTime() < TimeUnit.SECONDS.toNanos(1));
assertEquals(TYPE_PING,pingFrame.type);
assertEquals(1,pingFrame.payload1);
assertEquals(0,pingFrame.payload2);
assertFalse(pingFrame.ack);
}
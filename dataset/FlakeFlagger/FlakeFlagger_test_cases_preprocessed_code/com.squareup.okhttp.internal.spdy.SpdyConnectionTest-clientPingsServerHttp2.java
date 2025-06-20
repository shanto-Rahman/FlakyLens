@Test public void clientPingsServerHttp2() throws Exception {
assertTrue(ping.roundTripTime() > 0);
assertTrue(ping.roundTripTime() < TimeUnit.SECONDS.toNanos(1));
assertEquals(0,pingFrame.streamId);
assertEquals(1,pingFrame.payload1);
assertEquals(0x4f4b6f6b,pingFrame.payload2);
assertFalse(pingFrame.ack);
}
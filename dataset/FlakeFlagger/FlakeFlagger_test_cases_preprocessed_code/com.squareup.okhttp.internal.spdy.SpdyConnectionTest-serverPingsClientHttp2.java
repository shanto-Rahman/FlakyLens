@Test public void serverPingsClientHttp2() throws Exception {
assertEquals(TYPE_PING,ping.type);
assertEquals(0,ping.streamId);
assertEquals(2,ping.payload1);
assertEquals(3,ping.payload2);
assertTrue(ping.ack);
}
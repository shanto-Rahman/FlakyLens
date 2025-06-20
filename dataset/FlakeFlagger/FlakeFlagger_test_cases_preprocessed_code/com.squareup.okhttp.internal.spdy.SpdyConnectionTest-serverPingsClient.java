@Test public void serverPingsClient() throws Exception {
assertEquals(0,ping.streamId);
assertEquals(2,ping.payload1);
assertEquals(0,ping.payload2);
assertTrue(ping.ack);
}
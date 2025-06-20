@Test public void pushPromiseStream() throws Exception {
assertEquals(2,streamId);
assertEquals(2,streamId);
assertTrue(last);
assertEquals(-1,client.getSource().read(new OkBuffer(),1));
assertEquals(TYPE_HEADERS,peer.takeFrame().type);
assertEquals(2,events.size());
assertEquals(expectedRequestHeaders,events.get(0));
assertEquals(expectedResponseHeaders,events.get(1));
}
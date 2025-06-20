@Test public void doublePushPromise() throws Exception {
assertEquals(TYPE_HEADERS,peer.takeFrame().type);
assertEquals(PROTOCOL_ERROR,peer.takeFrame().errorCode);
}
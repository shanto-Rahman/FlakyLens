@Test public void connectionsArePooled() throws Exception {
assertEquals(0,server.takeRequest().getSequenceNumber());
assertEquals(1,server.takeRequest().getSequenceNumber());
assertEquals(2,server.takeRequest().getSequenceNumber());
}
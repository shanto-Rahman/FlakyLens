@Test public void connectionReuseWhenResponseBodyConsumed() throws Exception {
assertEquals('a',bytes.read());
assertEquals('b',bytes.read());
assertEquals('c',bytes.read());
assertEquals(0,server.takeRequest().getSequenceNumber());
assertEquals(1,server.takeRequest().getSequenceNumber());
}
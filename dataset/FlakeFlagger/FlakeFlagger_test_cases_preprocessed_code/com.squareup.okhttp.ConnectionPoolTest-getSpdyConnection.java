@Test public void getSpdyConnection() throws Exception {
assertSame(spdyA,pool.get(spdyAddress));
}
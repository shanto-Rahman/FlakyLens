@Test public void gettingSpdyConnectionPromotesItToFrontOfQueue() throws Exception {
assertSame(spdyA,pool.get(spdyAddress));
}
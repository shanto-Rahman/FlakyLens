@Test public void gettingConnectionReturnsOldestFirst() throws Exception {
assertSame(httpA,pool.get(httpAddress));
}
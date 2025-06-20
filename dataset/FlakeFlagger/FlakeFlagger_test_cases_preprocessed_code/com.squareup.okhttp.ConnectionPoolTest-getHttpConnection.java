@Test public void getHttpConnection() throws Exception {
assertSame(httpA,pool.get(httpAddress));
}
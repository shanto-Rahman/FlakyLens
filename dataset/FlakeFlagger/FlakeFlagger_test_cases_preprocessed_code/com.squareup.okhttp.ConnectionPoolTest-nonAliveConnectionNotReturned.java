@Test public void nonAliveConnectionNotReturned() throws Exception {
assertNull(pool.get(httpAddress));
}
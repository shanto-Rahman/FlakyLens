@Test public void idleConnectionNotReturned() throws Exception {
Thread.sleep(KEEP_ALIVE_DURATION_MS * 2);
assertNull(pool.get(httpAddress));
}
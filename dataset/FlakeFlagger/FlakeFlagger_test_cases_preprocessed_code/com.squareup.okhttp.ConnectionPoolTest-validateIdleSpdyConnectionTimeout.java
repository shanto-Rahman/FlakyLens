@Test public void validateIdleSpdyConnectionTimeout() throws Exception {
Thread.sleep((int)(KEEP_ALIVE_DURATION_MS * 0.7));
assertNull(pool.get(httpAddress));
Thread.sleep((int)(KEEP_ALIVE_DURATION_MS * 0.4));
assertNull(pool.get(httpAddress));
}
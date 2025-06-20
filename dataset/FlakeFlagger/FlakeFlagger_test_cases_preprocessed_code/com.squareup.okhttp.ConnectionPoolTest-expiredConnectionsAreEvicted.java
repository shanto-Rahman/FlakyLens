@Test public void expiredConnectionsAreEvicted() throws Exception {
Thread.sleep(2 * KEEP_ALIVE_DURATION_MS);
}
@Test public void deflateWithSyncFlush() throws Exception {
assertEquals(original,inflated.readUtf8(inflated.size()));
}
@Test public void deflateWithClose() throws Exception {
assertEquals(original,inflated.readUtf8(inflated.size()));
}
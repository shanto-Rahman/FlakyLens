@Test public void deflateWellCompressed() throws IOException {
assertEquals(original,inflated.readUtf8(inflated.size()));
}
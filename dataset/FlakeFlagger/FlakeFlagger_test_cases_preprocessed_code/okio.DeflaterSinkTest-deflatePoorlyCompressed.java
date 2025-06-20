@Test public void deflatePoorlyCompressed() throws IOException {
assertEquals(original,inflated.readByteString(inflated.size()));
}
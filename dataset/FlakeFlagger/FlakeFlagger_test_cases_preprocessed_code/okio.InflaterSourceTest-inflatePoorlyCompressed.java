@Test public void inflatePoorlyCompressed() throws Exception {
assertEquals(original,inflated.readByteString(inflated.size()));
}
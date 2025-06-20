@Test public void inflateWellCompressed() throws Exception {
assertEquals(original,readUtf8(inflated));
}
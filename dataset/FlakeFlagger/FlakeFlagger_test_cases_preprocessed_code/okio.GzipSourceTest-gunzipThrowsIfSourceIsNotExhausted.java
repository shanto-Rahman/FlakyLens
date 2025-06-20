@Test public void gunzipThrowsIfSourceIsNotExhausted() throws Exception {
assertEquals('a',gunzippedSource.readByte());
assertEquals('b',gunzippedSource.readByte());
assertEquals('c',gunzippedSource.readByte());
fail();
}
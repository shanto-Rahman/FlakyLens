@Test public void gunzipExhaustsSource() throws Exception {
assertEquals('a',gunzippedSource.readByte());
assertEquals('b',gunzippedSource.readByte());
assertEquals('c',gunzippedSource.readByte());
assertFalse(exhaustableSource.exhausted);
assertEquals(-1,gunzippedSource.read(new OkBuffer(),1));
assertTrue(exhaustableSource.exhausted);
}
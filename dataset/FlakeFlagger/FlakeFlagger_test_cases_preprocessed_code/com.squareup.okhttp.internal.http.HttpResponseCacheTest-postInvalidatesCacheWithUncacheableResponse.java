@Test public void postInvalidatesCacheWithUncacheableResponse() throws Exception {
assertEquals("A",readAscii(openConnection(url)));
assertEquals("B",readAscii(invalidate));
assertEquals("C",readAscii(openConnection(url)));
}
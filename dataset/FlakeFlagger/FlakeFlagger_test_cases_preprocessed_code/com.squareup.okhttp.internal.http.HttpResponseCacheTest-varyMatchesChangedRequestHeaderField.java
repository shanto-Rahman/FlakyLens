@Test public void varyMatchesChangedRequestHeaderField() throws Exception {
assertEquals("A",readAscii(frConnection));
assertEquals("B",readAscii(enConnection));
}
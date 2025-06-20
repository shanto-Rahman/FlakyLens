@Test public void emptyMessage() throws IOException {
assertEquals("",statusLine.message());
assertEquals(version,statusLine.httpMinorVersion());
assertEquals(code,statusLine.code());
}
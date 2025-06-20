@Test public void parse() throws IOException {
assertEquals(message,statusLine.message());
assertEquals(version,statusLine.httpMinorVersion());
assertEquals(code,statusLine.code());
}
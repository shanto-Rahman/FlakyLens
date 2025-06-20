@Test public void shoutcast() throws IOException {
assertEquals("OK",statusLine.message());
assertEquals(0,statusLine.httpMinorVersion());
assertEquals(200,statusLine.code());
}
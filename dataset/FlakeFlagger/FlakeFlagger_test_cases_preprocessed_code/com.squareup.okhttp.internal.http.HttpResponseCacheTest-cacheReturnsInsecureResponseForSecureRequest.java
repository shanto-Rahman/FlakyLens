@Test public void cacheReturnsInsecureResponseForSecureRequest() throws IOException {
assertEquals("ABC",readAscii(connection1));
assertEquals("DEF",readAscii(connection2));
}
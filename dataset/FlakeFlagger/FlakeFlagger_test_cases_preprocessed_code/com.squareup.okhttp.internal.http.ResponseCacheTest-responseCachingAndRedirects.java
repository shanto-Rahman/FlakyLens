@Test public void responseCachingAndRedirects() throws Exception {
assertEquals("ABC",readAscii(connection));
assertEquals("ABC",readAscii(connection));
}
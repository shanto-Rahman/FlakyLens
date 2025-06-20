@Test public void setIfModifiedSince() throws Exception {
assertEquals("A",readAscii(connection));
assertTrue(request.getHeaders().contains("If-Modified-Since: " + formatDate(since)));
}
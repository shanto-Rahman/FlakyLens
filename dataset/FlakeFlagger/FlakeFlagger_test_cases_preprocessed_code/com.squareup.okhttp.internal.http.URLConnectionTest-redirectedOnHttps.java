@Test public void redirectedOnHttps() throws IOException, InterruptedException {
assertEquals("This is the new location!",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
assertEquals("GET / HTTP/1.1",first.getRequestLine());
assertEquals("GET /foo HTTP/1.1",retry.getRequestLine());
assertEquals("Expected connection reuse",1,retry.getSequenceNumber());
}
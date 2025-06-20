@Test public void connectViaHttpsWithSSLFallback() throws IOException, InterruptedException {
assertEquals("GET /foo HTTP/1.1",request.getRequestLine());
}
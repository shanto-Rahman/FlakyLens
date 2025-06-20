@Test public void connectViaHttps() throws Exception {
assertEquals("GET /foo HTTP/1.1",request.getRequestLine());
}
@Test public void response305UseProxy() throws Exception {
assertEquals("This page has moved!",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
assertEquals("GET /foo HTTP/1.1",page1.getRequestLine());
assertEquals(1,server.getRequestCount());
}
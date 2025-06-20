@Test public void get() throws Exception {
assertEquals(200,connection.getResponseCode());
assertEquals("Sweet",connection.getResponseMessage());
assertEquals("GET /foo HTTP/1.1",request.getRequestLine());
}
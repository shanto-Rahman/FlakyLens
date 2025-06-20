public void testRedirect() throws Exception {
assertEquals("This is the new location!",reader.readLine());
assertEquals("GET / HTTP/1.1",first.getRequestLine());
assertEquals("GET /new-path HTTP/1.1",redirect.getRequestLine());
}
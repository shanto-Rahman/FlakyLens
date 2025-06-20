@Test public void userSuppliedContentLengthHeader() throws Exception {
assertEquals("POST /foo HTTP/1.1",request.getRequestLine());
assertArrayEquals(postBytes,request.getBody());
assertEquals(postBytes.length,Integer.parseInt(request.getHeader("Content-Length")));
}
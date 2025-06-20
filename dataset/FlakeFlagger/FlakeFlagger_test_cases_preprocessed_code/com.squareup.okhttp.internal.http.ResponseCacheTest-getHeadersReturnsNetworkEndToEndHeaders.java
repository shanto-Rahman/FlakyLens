@Test public void getHeadersReturnsNetworkEndToEndHeaders() throws Exception {
assertEquals("A",readAscii(connection1));
assertEquals("GET, HEAD",connection1.getHeaderField("Allow"));
assertEquals("A",readAscii(connection2));
assertEquals("GET, HEAD, PUT",connection2.getHeaderField("Allow"));
}
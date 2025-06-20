@Test public void getHeadersReturnsCachedHopByHopHeaders() throws Exception {
assertEquals("A",readAscii(connection1));
assertEquals("identity",connection1.getHeaderField("Transfer-Encoding"));
assertEquals("A",readAscii(connection2));
assertEquals("identity",connection2.getHeaderField("Transfer-Encoding"));
}
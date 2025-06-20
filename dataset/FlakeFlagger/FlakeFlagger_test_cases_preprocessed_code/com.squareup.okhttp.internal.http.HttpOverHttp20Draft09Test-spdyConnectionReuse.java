@Test public void spdyConnectionReuse() throws Exception {
assertEquals("ABC",readAscii(connection1.getInputStream(),3));
assertEquals("GHI",readAscii(connection2.getInputStream(),3));
assertEquals("DEF",readAscii(connection1.getInputStream(),3));
assertEquals("JKL",readAscii(connection2.getInputStream(),3));
assertEquals(0,server.takeRequest().getSequenceNumber());
assertEquals(1,server.takeRequest().getSequenceNumber());
}
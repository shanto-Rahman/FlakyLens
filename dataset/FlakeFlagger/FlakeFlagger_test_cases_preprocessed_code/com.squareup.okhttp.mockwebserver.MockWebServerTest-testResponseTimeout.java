public void testResponseTimeout() throws Exception {
assertEquals('A',in.read());
assertEquals('B',in.read());
assertEquals('C',in.read());
fail();
assertEquals('D',in2.read());
assertEquals('E',in2.read());
assertEquals('F',in2.read());
assertEquals(-1,in2.read());
assertEquals(0,server.takeRequest().getSequenceNumber());
assertEquals(0,server.takeRequest().getSequenceNumber());
}
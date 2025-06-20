@Test public void testStreamTransfer2() throws Exception {
assertEquals(i,buffer.writerIndex());
assertEquals(i + BLOCK_SIZE,buffer.writerIndex());
assertEquals(i,buffer.readerIndex());
assertEquals(i + BLOCK_SIZE,buffer.readerIndex());
assertTrue(Arrays.equals(expected,out.toByteArray()));
}
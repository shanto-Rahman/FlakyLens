@Test public void testStreamTransfer1() throws Exception {
assertEquals(BLOCK_SIZE,buffer.setBytes(i,in,BLOCK_SIZE));
assertEquals(-1,buffer.setBytes(i,in,0));
assertTrue(Arrays.equals(expected,out.toByteArray()));
}
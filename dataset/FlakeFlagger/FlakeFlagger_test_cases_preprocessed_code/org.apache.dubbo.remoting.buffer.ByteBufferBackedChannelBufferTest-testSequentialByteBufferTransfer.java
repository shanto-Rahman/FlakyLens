@Test public void testSequentialByteBufferTransfer(){
assertEquals(valueOffset + BLOCK_SIZE,value.position());
assertEquals(expectedValue.get(j),value.get(j));
}
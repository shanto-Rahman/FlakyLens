/** 
 * Test partial within a single chunk.
 */
@Test public void testPartialRead() throws Exception {
assertEquals(data.rewind().toByteString(),readData.rewind().toByteString());
assertEquals(length,info2.getLen());
assertEquals(data.rewind().toByteString().substring(start,start + length),readData2.rewind().toByteString());
}
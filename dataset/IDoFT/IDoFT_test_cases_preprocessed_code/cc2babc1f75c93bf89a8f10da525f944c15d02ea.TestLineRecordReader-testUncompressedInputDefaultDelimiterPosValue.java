@Test public void testUncompressedInputDefaultDelimiterPosValue() throws Exception {
assertEquals(10,value.getLength());
assertEquals(0,key.get());
assertEquals(2,value.getLength());
assertEquals(12,key.get());
assertFalse(reader.nextKeyValue());
assertEquals(16,key.get());
assertEquals(3,value.getLength());
assertEquals(16,key.get());
assertFalse(reader.nextKeyValue());
assertEquals(19,key.get());
assertEquals(9,value.getLength());
assertEquals(0,key.get());
assertEquals(0,value.getLength());
assertEquals(10,key.get());
assertFalse(reader.nextKeyValue());
assertEquals(12,key.get());
}
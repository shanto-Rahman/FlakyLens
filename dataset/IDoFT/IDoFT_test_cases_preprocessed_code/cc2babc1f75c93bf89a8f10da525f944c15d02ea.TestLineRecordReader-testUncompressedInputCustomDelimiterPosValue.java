@Test public void testUncompressedInputCustomDelimiterPosValue() throws Exception {
assertTrue("Expected record got nothing",reader.nextKeyValue());
assertEquals("Wrong length for record value",10,value.getLength());
assertEquals("Wrong position after record read",0,key.get());
assertTrue("Expected record got nothing",reader.nextKeyValue());
assertEquals("Wrong length for record value",2,value.getLength());
assertEquals("Wrong position after record read",12,key.get());
assertTrue("Expected record got nothing",reader.nextKeyValue());
assertEquals("Wrong length for record value",3,value.getLength());
assertEquals("Wrong position after record read",16,key.get());
assertFalse(reader.nextKeyValue());
assertEquals("Wrong position after record read",19,key.get());
assertNull("Unexpected key returned",key);
assertFalse("Unexpected record returned",reader.nextKeyValue());
assertNull("Unexpected key returned",key);
assertTrue("Expected record got nothing",reader.nextKeyValue());
assertEquals("Wrong position after record read",0,key.get());
assertEquals("Wrong length for record value",9,value.getLength());
assertFalse(reader.nextKeyValue());
assertEquals("Wrong position after record read",11,key.get());
assertNull("Unexpected key returned",key);
assertTrue("Expected record got nothing",reader.nextKeyValue());
assertEquals("Wrong position after record read",11,key.get());
assertEquals("Wrong length for record value",3,value.getLength());
assertTrue("Expected record got nothing",reader.nextKeyValue());
assertEquals("Wrong position after record read",16,key.get());
assertEquals("Wrong length for record value",3,value.getLength());
assertFalse(reader.nextKeyValue());
assertEquals("Wrong position after record read",19,key.get());
assertTrue("Expected record got nothing",reader.nextKeyValue());
assertTrue("abcd|efgh".equals(value.toString()));
assertEquals("Wrong position after record read",keyPosition,key.get());
if (reader.nextKeyValue()) {
assertTrue("ij|kl".equals(value.toString()));
assertEquals("Wrong position after record read",keyPosition,key.get());
}
if (reader.nextKeyValue()) {
assertTrue("mno|pqr".equals(value.toString()));
assertEquals("Wrong position after record read",keyPosition,key.get());
}
assertFalse("Unexpected record returned",reader.nextKeyValue());
assertEquals("Wrong position after record read",keyPosition,key.get());
assertNull("Unexpected key returned",key);
}
public void testWritePointInt() throws Exception {
assertNotNull(bytes);
assertEquals(4,bytes.length);
assertEquals(8,bytes[0]);
assertEquals(7,bytes[1]);
assertEquals(0x10,bytes[2]);
assertEquals(4,bytes[3]);
assertEquals(input,result);
}
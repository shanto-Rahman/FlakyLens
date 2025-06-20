public void testPointArrayPacked() throws Exception {
assertEquals(12,bytes.length);
assertEquals(0xA,bytes[0]);
assertEquals(10,bytes[1]);
assertEquals(4,bytes[2]);
assertEquals(8,bytes[3]);
assertEquals(1,bytes[4]);
assertEquals(0x10,bytes[5]);
assertEquals(4,bytes[6]);
assertEquals(4,bytes[7]);
assertEquals(8,bytes[8]);
assertEquals(3,bytes[9]);
assertEquals(0x10,bytes[10]);
assertEquals(8,bytes[11]);
}
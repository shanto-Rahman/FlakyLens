@Test public void testSource(){
assertEquals(40,source.available());
assertEquals(0,source.readBits(1));
assertEquals(39,source.available());
assertEquals(0,source.readBits(6));
assertEquals(33,source.available());
assertEquals(1,source.readBits(1));
assertEquals(32,source.available());
assertEquals(2,source.readBits(8));
assertEquals(24,source.available());
assertEquals(12,source.readBits(10));
assertEquals(14,source.available());
assertEquals(16,source.readBits(8));
assertEquals(6,source.available());
assertEquals(5,source.readBits(6));
assertEquals(0,source.available());
}
@Test public void testAppendBits(){
assertEquals(1,v.getSize());
assertEquals(0x80000000L,getUnsignedInt(v,0));
assertEquals(8,v.getSize());
assertEquals(0xff000000L,getUnsignedInt(v,0));
assertEquals(12,v.getSize());
assertEquals(0xff700000L,getUnsignedInt(v,0));
}
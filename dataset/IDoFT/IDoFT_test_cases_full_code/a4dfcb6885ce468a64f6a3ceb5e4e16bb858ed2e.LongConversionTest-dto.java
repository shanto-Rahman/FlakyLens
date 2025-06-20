@Test public void dto(){
  LongHolder lh=new LongHolder();
  lh.hex=0XFEDCBA9876543210L;
  lh.unsigned=Long.MIN_VALUE;
  lh.timestamp=0x05432108090a0bL;
  assertEquals("!LongHolder {\n" + "  unsigned: 9223372036854775808,\n" + "  hex: fedcba9876543210,\n"+ "  timestamp: 2016-12-08T08:00:31.345163\n"+ "}\n",lh.toString());
  LongConversionTest.LongHolder lh2=Marshallable.fromString(lh.toString());
  assertEquals(lh2,lh);
}

@Test public void dto(){
assertEquals("!LongHolder {\n" + "  unsigned: 9223372036854775808,\n" + "  hex: fedcba9876543210,\n"+ "  timestamp: 2016-12-08T08:00:31.345163\n"+ "}\n",lh.toString());
assertEquals(lh2,lh);
}
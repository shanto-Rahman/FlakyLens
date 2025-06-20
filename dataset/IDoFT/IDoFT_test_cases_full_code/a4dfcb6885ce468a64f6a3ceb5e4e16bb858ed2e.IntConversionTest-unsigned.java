@Test public void unsigned(){
  UnsignedHolder uh=new UnsignedHolder();
  uh.u8=-1;
  uh.u16=-1;
  uh.u32=-1;
  assertEquals("!net.openhft.chronicle.wire.IntConversionTest$UnsignedHolder {\n" + "  u8: 255,\n" + "  u16: 65535,\n"+ "  u32: 4294967295\n"+ "}\n",uh.toString());
  UnsignedHolder uh2=Marshallable.fromString(uh.toString());
  assertEquals(uh2,uh);
}

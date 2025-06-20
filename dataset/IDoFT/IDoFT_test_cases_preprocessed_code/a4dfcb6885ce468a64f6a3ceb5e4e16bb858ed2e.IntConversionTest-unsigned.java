@Test public void unsigned(){
assertEquals("!net.openhft.chronicle.wire.IntConversionTest$UnsignedHolder {\n" + "  u8: 255,\n" + "  u16: 65535,\n"+ "  u32: 4294967295\n"+ "}\n",uh.toString());
assertEquals(uh2,uh);
}
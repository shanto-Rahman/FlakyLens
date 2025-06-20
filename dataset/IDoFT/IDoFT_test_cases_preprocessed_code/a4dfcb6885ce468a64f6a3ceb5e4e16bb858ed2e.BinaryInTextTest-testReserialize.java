@Test public void testReserialize(){
assertEquals("!net.openhft.chronicle.wire.BinaryInTextTest$BIT {\n" + "  b: !!binary AAAAAAA=,\n" + "  c: !!binary CCCCCCCC\n"+ "}\n",bit.toString());
}
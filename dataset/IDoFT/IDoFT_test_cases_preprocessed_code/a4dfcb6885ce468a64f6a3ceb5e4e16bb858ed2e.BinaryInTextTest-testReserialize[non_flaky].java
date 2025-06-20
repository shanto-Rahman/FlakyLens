@Test public void testReserialize(){
assertTrue(bitToString.equals("!net.openhft.chronicle.wire.BinaryInTextTest$BIT {\n" + "  b: !!binary AAAAAAA=,\n" + "  c: !!binary CCCCCCCC\n"+ "}\n") || bitToString.equals("!net.openhft.chronicle.wire.BinaryInTextTest$BIT {\n" + "  c: !!binary CCCCCCCC,\n" + "  b: !!binary AAAAAAA=\n"+ "}\n"));
}
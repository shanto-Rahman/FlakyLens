@Test public void testReserialize(){
  BIT b=new BIT();
  byte[] a=new byte[5];
  b.b=Bytes.wrapForRead(a);
  b.c=Bytes.wrapForRead(a);
  BIT bit=Marshallable.fromString(BIT.class,"{\n" + "b: !!binary AAAAAAA=,\n" + "c: !!binary CCCCCCCC,\n"+ "}");
  String bitToString=bit.toString();
  assertTrue(bitToString.equals("!net.openhft.chronicle.wire.BinaryInTextTest$BIT {\n" + "  b: !!binary AAAAAAA=,\n" + "  c: !!binary CCCCCCCC\n"+ "}\n") || bitToString.equals("!net.openhft.chronicle.wire.BinaryInTextTest$BIT {\n" + "  c: !!binary CCCCCCCC,\n" + "  b: !!binary AAAAAAA=\n"+ "}\n"));
}

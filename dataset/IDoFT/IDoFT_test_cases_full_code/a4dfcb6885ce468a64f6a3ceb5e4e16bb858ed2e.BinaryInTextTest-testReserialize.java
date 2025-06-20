@Test public void testReserialize(){
  BIT b=new BIT();
  byte[] a=new byte[5];
  b.b=Bytes.wrapForRead(a);
  b.c=Bytes.wrapForRead(a);
  System.out.println(b);
  BIT bit=Marshallable.fromString(BIT.class,"{\n" + "b: !!binary AAAAAAA=,\n" + "c: !!binary CCCCCCCC,\n"+ "}");
  assertEquals("!net.openhft.chronicle.wire.BinaryInTextTest$BIT {\n" + "  b: !!binary AAAAAAA=,\n" + "  c: !!binary CCCCCCCC\n"+ "}\n",bit.toString());
}

@Test public void testABCStringBuilder(){
  @NotNull Wire wire=createWire();
  wire.bytes().append("A: \"hi\",\n" + "B: 'hi',\n" + "C: hi,\n");
  ABC abc=new ABC();
  for (int i=0; i < 5; i++) {
    wire.bytes().readPosition(0);
    assertEquals("!net.openhft.chronicle.wire.TextWireTest$ABC {\n" + "  A: hi,\n" + "  B: hi,\n"+ "  C: hi\n"+ "}\n",wire.getValueIn().object(abc,ABC.class).toString());
  }
}

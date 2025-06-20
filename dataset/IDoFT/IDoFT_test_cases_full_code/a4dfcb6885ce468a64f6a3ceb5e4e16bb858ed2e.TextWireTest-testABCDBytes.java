@Test public void testABCDBytes(){
  @NotNull Wire wire=createWire();
  wire.bytes().append("A: \"hi\",\n" + "B: 'hi',\n" + "C: hi,\n"+ "D: bye,\n");
  ABCD abcd=new ABCD();
  try {
    for (int i=0; i < 5; i++) {
      wire.bytes().readPosition(0);
      assertEquals("!net.openhft.chronicle.wire.TextWireTest$ABCD {\n" + "  A: hi,\n" + "  B: hi,\n"+ "  C: hi,\n"+ "  D: bye\n"+ "}\n",wire.getValueIn().object(abcd,ABCD.class).toString());
    }
  }
  finally {
    abcd.releaseAll();
    WireMarshaller wm=WireMarshaller.WIRE_MARSHALLER_CL.get(ABCD.class);
    ABCD abcd0=(ABCD)wm.defaultValue();
    abcd0.releaseAll();
  }
}

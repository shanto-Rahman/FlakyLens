@Test public void testSubclasses(){
  Wire wire=new TextWire(Bytes.allocateElasticOnHeap(256));
  Event writer=wire.methodWriterBuilder(Event.class).genericEvent("event").build();
  writer.event("top",new VanillaMethodReaderTest.MRT1("one"));
  writer.event("top",new VanillaMethodReaderTest.MRT2("one","two"));
  writer.event("mid",new VanillaMethodReaderTest.MRT1("1"));
  writer.event("mid",new VanillaMethodReaderTest.MRT2("1","2"));
  StringWriter sw=new StringWriter();
  MethodReader reader=wire.methodReader(Mocker.logging(VanillaMethodReaderTest.MRTListener.class,"subs ",sw));
  for (int i=0; i < 4; i++) {
    assertTrue(reader.readOne());
  }
  assertFalse(reader.readOne());
  String expected="subs top[!net.openhft.chronicle.wire.method.VanillaMethodReaderTest$MRT1 {\n" + "  field1: one,\n" + "  value: a\n"+ "}\n"+ "]\n"+ "subs top[!net.openhft.chronicle.wire.method.VanillaMethodReaderTest$MRT2 {\n"+ "  field1: one,\n"+ "  value: a,\n"+ "  field2: two\n"+ "}\n"+ "]\n"+ "subs mid[!net.openhft.chronicle.wire.method.VanillaMethodReaderTest$MRT1 {\n"+ "  field1: \"1\",\n"+ "  value: a\n"+ "}\n"+ "]\n"+ "subs mid[!net.openhft.chronicle.wire.method.VanillaMethodReaderTest$MRT2 {\n"+ "  field1: \"1\",\n"+ "  value: a,\n"+ "  field2: \"2\"\n"+ "}\n"+ "]\n";
  String actual=sw.toString().replace("\r","");
  assertEquals(expected,actual);
}

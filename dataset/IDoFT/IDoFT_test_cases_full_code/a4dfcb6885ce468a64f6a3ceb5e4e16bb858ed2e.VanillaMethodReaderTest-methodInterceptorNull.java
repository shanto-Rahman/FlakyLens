@Test public void methodInterceptorNull(){
  Wire wire=new TextWire(Bytes.allocateElasticOnHeap(256)).useTextDocuments();
  MRTListener writer=wire.methodWriterBuilder(MRTListener.class).build();
  writer.top(new MRT1("one"));
  writer.top(new MRT2("one","two"));
  writer.mid(new MRT1("1"));
  writer.mid(new MRT2("1","2"));
  assertEquals("top: !net.openhft.chronicle.wire.method.VanillaMethodReaderTest$MRT1 {\n" + "  field1: one,\n" + "  value: a\n"+ "}\n"+ "...\n"+ "top: !net.openhft.chronicle.wire.method.VanillaMethodReaderTest$MRT2 {\n"+ "  field1: one,\n"+ "  value: a,\n"+ "  field2: two\n"+ "}\n"+ "...\n"+ "mid: {\n"+ "  field1: \"1\",\n"+ "  value: a\n"+ "}\n"+ "...\n"+ "mid: !net.openhft.chronicle.wire.method.VanillaMethodReaderTest$MRT2 {\n"+ "  field1: \"1\",\n"+ "  value: a,\n"+ "  field2: \"2\"\n"+ "}\n"+ "...\n",wire.toString());
}

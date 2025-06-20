@Test public void methodInterceptor(){
  Wire wire=new TextWire(Bytes.allocateElasticOnHeap(256)).useTextDocuments();
  MRTListener writer=wire.methodWriterBuilder(MRTListener.class).methodWriterListener((m,a) -> IntStream.range(0,a.length).filter(i -> a[i] instanceof MRT1).forEach(i -> ((MRT1)a[i]).value="x")).get();
  writer.timed(1234567890L);
  writer.top(new MRT1("one"));
  writer.top(new MRT2("one","two"));
  writer.mid(new MRT1("1"));
  writer.mid(new MRT2("1","2"));
  assertEquals("timed: 1234567890\n" + "...\n" + "top: !net.openhft.chronicle.wire.method.VanillaMethodReaderTest$MRT1 {\n"+ "  field1: one,\n"+ "  value: x\n"+ "}\n"+ "...\n"+ "top: !net.openhft.chronicle.wire.method.VanillaMethodReaderTest$MRT2 {\n"+ "  field1: one,\n"+ "  value: x,\n"+ "  field2: two\n"+ "}\n"+ "...\n"+ "mid: {\n"+ "  field1: \"1\",\n"+ "  value: x\n"+ "}\n"+ "...\n"+ "mid: !net.openhft.chronicle.wire.method.VanillaMethodReaderTest$MRT2 {\n"+ "  field1: \"1\",\n"+ "  value: x,\n"+ "  field2: \"2\"\n"+ "}\n"+ "...\n",wire.toString());
}

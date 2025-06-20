@Test public void testMyInnnerMap(){
  @NotNull MyMarshable myMarshable=new MyMarshable().name("rob");
  myMarshable.commission().put("hello",123.4);
  myMarshable.nested=new MyNested("text");
  String asString=myMarshable.toString();
  Assert.assertEquals("!net.openhft.chronicle.wire.InnerMapTest$MyMarshable {\n" + "  name: rob,\n" + "  commission: {\n"+ "    hello: 123.4\n"+ "  },\n"+ "  nested: !net.openhft.chronicle.wire.InnerMapTest$MyNested {\n"+ "    value: text\n"+ "  }\n"+ "}\n",asString);
  @SuppressWarnings("rawtypes") Bytes b=Bytes.elasticByteBuffer();
  @NotNull Wire w=new BinaryWire(b);
  try (DocumentContext dc=w.writingDocument(false)){
    dc.wire().write("marshable").typedMarshallable(myMarshable);
  }
   try (DocumentContext dc=w.readingDocument()){
    @Nullable MyMarshable tm=dc.wire().read(() -> "marshable").typedMarshallable();
    Assert.assertEquals(asString,tm.toString());
  }
   b.releaseLast();
}

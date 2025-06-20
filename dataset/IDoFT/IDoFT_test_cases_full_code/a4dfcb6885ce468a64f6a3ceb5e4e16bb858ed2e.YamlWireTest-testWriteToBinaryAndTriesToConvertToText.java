@Test public void testWriteToBinaryAndTriesToConvertToText(){
  Bytes b=Bytes.elasticByteBuffer();
  Wire wire=WireType.BINARY.apply(b);
  @NotNull Map<String,String> data=Collections.singletonMap("key","value");
  @NotNull HashMap map=new HashMap();
  map.put("some",data);
  map.put("some-other",data);
  try (DocumentContext dc=wire.writingDocument()){
    wire.write("map").object(map);
  }
   final String textYaml=Wires.fromSizePrefixedBlobs(b);
  System.out.println(textYaml);
  @Nullable Object o=WireType.TEXT.fromString(textYaml);
  Assert.assertEquals("{map={some={key=value}, some-other={key=value}}}",o.toString());
  b.releaseLast();
}

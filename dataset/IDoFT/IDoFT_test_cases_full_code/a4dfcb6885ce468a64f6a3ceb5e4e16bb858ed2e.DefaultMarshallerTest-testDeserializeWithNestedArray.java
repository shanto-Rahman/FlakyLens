@Test public void testDeserializeWithNestedArray(){
  ClassAliasPool.CLASS_ALIASES.addAlias(NestedEnum.class);
  DMOuterClassWithEmbeddedArray dmOuterClass=ObjectUtils.newInstance(DMOuterClassWithEmbeddedArray.class);
  @NotNull DMOuterClassWithEmbeddedArray oc=new DMOuterClassWithEmbeddedArray("words");
  oc.enums=new NestedEnum[3];
  oc.enums[0]=NestedEnum.ONE;
  oc.enums[1]=NestedEnum.TWO;
  oc.enums[2]=NestedEnum.THREE;
  assertEquals("!net.openhft.chronicle.wire.DefaultMarshallerTest$DMOuterClassWithEmbeddedArray {\n" + "  str: words,\n" + "  enums: [ ONE, TWO, THREE ]\n"+ "}\n",oc.toString());
  @NotNull Wire text=new TextWire(Bytes.allocateElasticOnHeap(128));
  oc.writeMarshallable(text);
  @NotNull DMOuterClassWithEmbeddedArray oc2=new DMOuterClassWithEmbeddedArray();
  oc2.readMarshallable(text);
  assertEquals(oc,oc2);
  text.bytes().releaseLast();
}

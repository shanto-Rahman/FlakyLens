@Test public void testDeserialize(){
  ClassAliasPool.CLASS_ALIASES.addAlias(DMNestedClass.class);
  DMOuterClass dmOuterClass=ObjectUtils.newInstance(DMOuterClass.class);
  assertNotNull(dmOuterClass.nested);
  @NotNull DMOuterClass oc=new DMOuterClass("words",true,(byte)1,2,3,4,5,(short)6);
  oc.nested.add(new DMNestedClass("hi",111));
  oc.nested.add(new DMNestedClass("bye",999));
  oc.map.put("key",new DMNestedClass("value",1));
  oc.map.put("keyz",new DMNestedClass("valuez",1111));
  assertEquals("!net.openhft.chronicle.wire.DMOuterClass {\n" + "  text: words,\n" + "  b: true,\n"+ "  bb: 1,\n"+ "  s: 6,\n"+ "  f: 3.0,\n"+ "  d: 2.0,\n"+ "  l: 5,\n"+ "  i: 4,\n"+ "  nested: [\n"+ "    { str: hi, num: 111 },\n"+ "    { str: bye, num: 999 }\n"+ "  ],\n"+ "  map: {\n"+ "    key: { str: value, num: 1 },\n"+ "    keyz: { str: valuez, num: 1111 }\n"+ "  }\n"+ "}\n",oc.toString());
  @NotNull Wire text=new TextWire(Bytes.allocateElasticOnHeap(64));
  oc.writeMarshallable(text);
  @NotNull DMOuterClass oc2=new DMOuterClass();
  oc2.readMarshallable(text);
  assertEquals(oc,oc2);
  text.bytes().releaseLast();
}

@Test public void testDeserialize(){
assertNotNull(dmOuterClass.nested);
assertEquals("!net.openhft.chronicle.wire.DMOuterClass {\n" + "  text: words,\n" + "  b: true,\n"+ "  bb: 1,\n"+ "  s: 6,\n"+ "  f: 3.0,\n"+ "  d: 2.0,\n"+ "  l: 5,\n"+ "  i: 4,\n"+ "  nested: [\n"+ "    { str: hi, num: 111 },\n"+ "    { str: bye, num: 999 }\n"+ "  ],\n"+ "  map: {\n"+ "    key: { str: value, num: 1 },\n"+ "    keyz: { str: valuez, num: 1111 }\n"+ "  }\n"+ "}\n",oc.toString());
assertEquals(oc,oc2);
}
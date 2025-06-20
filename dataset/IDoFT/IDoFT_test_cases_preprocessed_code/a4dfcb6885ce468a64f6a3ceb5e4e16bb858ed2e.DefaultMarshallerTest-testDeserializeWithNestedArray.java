@Test public void testDeserializeWithNestedArray(){
assertEquals("!net.openhft.chronicle.wire.DefaultMarshallerTest$DMOuterClassWithEmbeddedArray {\n" + "  str: words,\n" + "  enums: [ ONE, TWO, THREE ]\n"+ "}\n",oc.toString());
assertEquals(oc,oc2);
}
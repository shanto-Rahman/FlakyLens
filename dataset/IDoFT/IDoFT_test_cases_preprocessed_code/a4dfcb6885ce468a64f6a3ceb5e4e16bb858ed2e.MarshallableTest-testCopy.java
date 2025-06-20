@Test public void testCopy(){
assertEquals("!net.openhft.chronicle.wire.MarshallableTest$DTO1 {\n" + "  one: CLASS,\n" + "  two: [\n"+ "    1,\n"+ "    22\n"+ "  ],\n"+ "  three: 2018-11-02\n"+ "}\n",WireType.TEXT.asString(dto1));
}
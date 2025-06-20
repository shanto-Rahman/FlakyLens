@Test public void testABCStringBuilder(){
assertEquals("!net.openhft.chronicle.wire.TextWireTest$ABC {\n" + "  A: hi,\n" + "  B: hi,\n"+ "  C: hi\n"+ "}\n",wire.getValueIn().object(abc,ABC.class).toString());
}
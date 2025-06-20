@Test public void testABCDBytes(){
assertEquals("!net.openhft.chronicle.wire.TextWireTest$ABCD {\n" + "  A: hi,\n" + "  B: hi,\n"+ "  C: hi,\n"+ "  D: bye\n"+ "}\n",wire.getValueIn().object(abcd,ABCD.class).toString());
abcd.releaseAll();//IT
abcd0.releaseAll();//IT
}
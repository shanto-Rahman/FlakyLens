@Test public void longConverter(){
assertEquals("!net.openhft.chronicle.wire.TextWireTest$TwoLongs {\n" + "  hexadecimal: 1234567890abcdef,\n" + "  hexa2: ffffffffffffffff\n"+ "}\n",twoLongs.toString());
assertEquals(twoLongs,Marshallable.fromString(twoLongs.toString()));
}
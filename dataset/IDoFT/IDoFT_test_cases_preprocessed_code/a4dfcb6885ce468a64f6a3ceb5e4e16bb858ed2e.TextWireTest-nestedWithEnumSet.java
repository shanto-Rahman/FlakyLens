@Test public void nestedWithEnumSet(){
assertEquals("hello: {\n" + "  list: [\n" + "    { name: none },\n"+ "    { name: one, timeUnits: [ DAYS ] },\n"+ "    { name: two, timeUnits: [ HOURS, DAYS ] }\n"+ "  ]\n"+ "}\n",wire.toString());
assertEquals(n.toString(),a.toString());
assertEquals(n,a);
}
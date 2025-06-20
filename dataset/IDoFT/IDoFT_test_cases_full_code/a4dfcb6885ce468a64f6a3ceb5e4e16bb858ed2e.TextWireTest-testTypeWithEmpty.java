@Test public void testTypeWithEmpty(){
  ClassAliasPool.CLASS_ALIASES.addAlias(NestedA.class,NestedB.class);
  NestedA a=Marshallable.fromString("!NestedA {\n" + "  b: !NestedB,\n" + "  value: 12345\n"+ "}");
  assertEquals("!NestedA {\n" + "  b: {\n" + "    field1: 0.0\n"+ "  },\n"+ "  value: 12345\n"+ "}\n",a.toString());
}

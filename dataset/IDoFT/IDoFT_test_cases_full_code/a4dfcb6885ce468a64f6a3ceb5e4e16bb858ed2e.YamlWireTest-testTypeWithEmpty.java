@Test public void testTypeWithEmpty(){
  ClassAliasPool.CLASS_ALIASES.addAlias(YNestedA.class,YNestedB.class);
  YNestedA a=Marshallable.fromString("!YNestedA {\n" + "  b: !YNestedB,\n" + "  value: 12345\n"+ "}");
  assertEquals("!YNestedA {\n" + "  b: {\n" + "    field1: 0.0\n"+ "  },\n"+ "  value: 12345\n"+ "}\n",a.toString());
}

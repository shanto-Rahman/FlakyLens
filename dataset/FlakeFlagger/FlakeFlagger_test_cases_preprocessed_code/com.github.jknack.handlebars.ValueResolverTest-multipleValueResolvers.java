@Test public void multipleValueResolvers(){
assertNotNull(context);
assertEquals("a",context.get("base"));
assertEquals("b",context.get("child"));
assertEquals("a",context.get("baseProperty"));
assertEquals("b",context.get("childProperty"));
assertEquals("a",context.get("getBaseProperty"));
assertEquals("b",context.get("getChildProperty"));
assertEquals("a",context.get("map.base"));
assertEquals("b",context.get("map.child"));
}
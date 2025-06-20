@Test public void combineNested(){
assertNotNull(context);
assertEquals("baseProperty",context.get("baseProperty"));
assertEquals(expanded,context.get("expanded"));
assertEquals("a",context.get("expanded.a"));
assertEquals(true,context.get("expanded.b"));
}
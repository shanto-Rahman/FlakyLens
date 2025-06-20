@Test public void methodResolver(){
assertNotNull(context);
assertEquals("a",context.get("getBaseProperty"));
assertEquals("b",context.get("getChildProperty"));
}
@Test public void combine(){
assertNotNull(context);
assertEquals("baseProperty",context.get("baseProperty"));
assertEquals("value",context.get("expanded"));
}
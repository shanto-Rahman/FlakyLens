@Test public void expanded(){
assertNotNull(context);
assertEquals("baseProperty",context.get("baseProperty"));
assertEquals(null,context.get("expanded"));
assertEquals("a",context.get("a"));
assertEquals(true,context.get("b"));
}
@Test public void mapResolver(){
assertNotNull(context);
assertEquals("a",context.get("base"));
assertEquals("b",context.get("child"));
}
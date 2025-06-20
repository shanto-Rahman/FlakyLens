@Test public void fieldResolver(){
assertNotNull(context);
assertEquals("a",context.get("base"));
assertEquals("b",context.get("child"));
}
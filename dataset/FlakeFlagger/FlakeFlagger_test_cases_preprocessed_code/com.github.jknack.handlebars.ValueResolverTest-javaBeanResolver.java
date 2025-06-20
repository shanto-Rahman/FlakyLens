@Test public void javaBeanResolver(){
assertNotNull(context);
assertEquals("a",context.get("baseProperty"));
assertEquals("b",context.get("childProperty"));
}
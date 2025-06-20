@Test public void customLookup(){
assertNotNull(context);
assertEquals("baseProperty",context.get("baseProperty"));
assertEquals("baseProperty",context.get("childProperty"));
}
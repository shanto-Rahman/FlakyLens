@Test public void customLookupOnChildClass(){
assertNotNull(context);
assertEquals("baseProperty",context.get("baseProperty"));
assertEquals("childProperty",context.get("childProperty"));
}
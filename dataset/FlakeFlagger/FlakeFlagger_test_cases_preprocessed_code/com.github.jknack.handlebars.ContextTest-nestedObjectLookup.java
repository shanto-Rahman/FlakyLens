@Test public void nestedObjectLookup(){
assertNotNull(context);
assertEquals("value",context.get("nested.simple"));
}
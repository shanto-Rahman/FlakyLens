@Test public void singleMapLookup(){
assertNotNull(context);
assertEquals("value",context.get("simple"));
}
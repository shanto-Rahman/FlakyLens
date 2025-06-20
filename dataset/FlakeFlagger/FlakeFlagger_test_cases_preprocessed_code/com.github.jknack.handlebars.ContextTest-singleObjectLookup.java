@Test public void singleObjectLookup(){
assertNotNull(context);
assertEquals("value",context.get("simple"));
}
@Test public void nestedMapLookup(){
assertNotNull(context);
assertEquals("value",context.get("nested.simple"));
}
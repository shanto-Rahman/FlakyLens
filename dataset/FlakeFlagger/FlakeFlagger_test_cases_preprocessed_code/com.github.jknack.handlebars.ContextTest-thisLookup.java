@Test public void thisLookup(){
assertNotNull(context);
assertEquals("String",context.get("this"));
}
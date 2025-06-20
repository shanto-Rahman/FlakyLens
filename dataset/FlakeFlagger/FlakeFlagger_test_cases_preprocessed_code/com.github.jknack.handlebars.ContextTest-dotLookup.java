@Test public void dotLookup(){
assertNotNull(context);
assertEquals("String",context.get("."));
}
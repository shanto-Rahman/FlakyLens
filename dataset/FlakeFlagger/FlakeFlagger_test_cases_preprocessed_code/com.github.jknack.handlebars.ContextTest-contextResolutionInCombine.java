@Test public void contextResolutionInCombine(){
assertNotNull(context);
assertEquals("baseProperty",context.get("baseProperty"));
}
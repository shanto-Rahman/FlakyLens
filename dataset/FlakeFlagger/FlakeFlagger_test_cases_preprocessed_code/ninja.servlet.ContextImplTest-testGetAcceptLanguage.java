@Test public void testGetAcceptLanguage(){
assertEquals(language,context.getAcceptLanguage());
assertNull(context.getAcceptLanguage());
assertEquals(language,context.getAcceptLanguage());
}
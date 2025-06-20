@Test public void testIsLanguageDirectlySupportedByThisApplication(){
assertTrue(lang.isLanguageDirectlySupportedByThisApplication("en"));
assertFalse(lang.isLanguageDirectlySupportedByThisApplication("de"));
assertTrue(lang.isLanguageDirectlySupportedByThisApplication("en"));
assertTrue(lang.isLanguageDirectlySupportedByThisApplication("de"));
assertTrue(lang.isLanguageDirectlySupportedByThisApplication("se"));
assertFalse(lang.isLanguageDirectlySupportedByThisApplication("tk"));
}
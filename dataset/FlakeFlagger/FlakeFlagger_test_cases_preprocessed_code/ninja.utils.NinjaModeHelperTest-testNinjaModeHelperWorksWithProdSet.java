@Test public void testNinjaModeHelperWorksWithProdSet(){
assertEquals(NinjaMode.prod,NinjaModeHelper.determineModeFromSystemProperties().get());
assertEquals(NinjaMode.prod,NinjaModeHelper.determineModeFromSystemPropertiesOrDevIfNotSet());
}
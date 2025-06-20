@Test public void testNinjaModeHelperWorksWithDevSet(){
assertEquals(NinjaMode.dev,NinjaModeHelper.determineModeFromSystemProperties().get());
assertEquals(NinjaMode.dev,NinjaModeHelper.determineModeFromSystemPropertiesOrDevIfNotSet());
}
@Test public void testNinjaModeHelperWorksWithTestSet(){
assertEquals(NinjaMode.test,NinjaModeHelper.determineModeFromSystemProperties().get());
assertEquals(NinjaMode.test,NinjaModeHelper.determineModeFromSystemPropertiesOrDevIfNotSet());
}
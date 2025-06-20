@Test public void testDisableCacheInitParamInDevelopmentMode() throws Exception {
Assert.assertEquals(true,victim.getConfiguration().isDebug());
Assert.assertEquals(true,victim.getConfiguration().isDisableCache());
}
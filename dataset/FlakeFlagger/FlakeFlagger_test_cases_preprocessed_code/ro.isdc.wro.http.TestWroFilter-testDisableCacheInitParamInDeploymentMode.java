@Test public void testDisableCacheInitParamInDeploymentMode() throws Exception {
Assert.assertEquals(false,victim.getConfiguration().isDebug());
Assert.assertEquals(false,victim.getConfiguration().isDisableCache());
}
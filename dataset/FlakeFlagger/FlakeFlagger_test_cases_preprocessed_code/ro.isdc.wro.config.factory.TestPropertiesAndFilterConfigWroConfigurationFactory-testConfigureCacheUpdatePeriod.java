@Test public void testConfigureCacheUpdatePeriod(){
Assert.assertEquals(10,config.getCacheUpdatePeriod());
Assert.assertEquals(true,config.isDebug());
}
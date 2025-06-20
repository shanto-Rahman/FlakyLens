@Test public void testConfigureCacheUpdatePeriodWithPropertiesFileSet(){
Assert.assertEquals(10,config.getCacheUpdatePeriod());
Assert.assertEquals(true,config.isDebug());
Assert.assertEquals(10,config.getCacheUpdatePeriod());
Assert.assertEquals(30,config.getModelUpdatePeriod());
}
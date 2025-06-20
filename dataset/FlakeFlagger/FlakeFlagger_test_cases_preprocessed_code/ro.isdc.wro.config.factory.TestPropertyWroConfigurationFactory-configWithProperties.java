@Test public void configWithProperties(){
Assert.assertEquals(10,config.getCacheUpdatePeriod());
Assert.assertEquals(20,config.getModelUpdatePeriod());
Assert.assertEquals(30,config.getResourceWatcherUpdatePeriod());
Assert.assertEquals(true,config.isDisableCache());
Assert.assertEquals(false,config.isGzipEnabled());
Assert.assertEquals(true,config.isCacheGzippedContent());
Assert.assertEquals(true,config.isParallelPreprocessing());
Assert.assertEquals(false,config.isIgnoreEmptyGroup());
Assert.assertEquals(true,config.isIgnoreFailingProcessor());
Assert.assertEquals(5000,config.getConnectionTimeout());
}
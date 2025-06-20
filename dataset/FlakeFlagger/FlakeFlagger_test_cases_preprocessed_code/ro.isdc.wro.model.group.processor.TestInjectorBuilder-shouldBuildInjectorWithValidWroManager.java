@Test public void shouldBuildInjectorWithValidWroManager(){
assertNotNull(injector);
assertNotNull(sample.namingStrategy);
assertNotNull(sample.preProcessorExecutor);
assertNotNull(sample.processorsFactory);
assertNotNull(sample.uriLocatorFactory);
assertNotNull(sample.callbackRegistry);
assertSame(injector,sample.injector);
assertNotNull(sample.groupsProcessor);
assertNotNull(sample.metaDataFactory);
assertNotNull(sample.bundleProcessor);
}
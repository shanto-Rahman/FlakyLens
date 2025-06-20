@Test public void shouldBuildValidInjectorWithFewFieldsSet() throws Exception {
assertNotNull(injector);
assertNotNull(sample.preProcessorExecutor);
assertNotNull(sample.callbackRegistry);
assertSame(injector,sample.injector);
assertNotNull(sample.groupsProcessor);
assertNotNull(sample.modelFactory);
assertNotNull(sample.groupExtractor);
assertNotNull(sample.cacheStrategy);
assertNotNull(sample.hashBuilder);
assertNotNull(sample.readOnlyContext);
assertNotNull(sample.metaDataFactory);
assertNotNull(sample.cacheKeyFactory);
assertNotNull(sample.bundleProcessor);
}
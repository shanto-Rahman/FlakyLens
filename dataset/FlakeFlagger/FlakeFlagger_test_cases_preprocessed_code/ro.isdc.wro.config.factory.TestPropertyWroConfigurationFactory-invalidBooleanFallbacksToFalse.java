@Test public void invalidBooleanFallbacksToFalse(){
Assert.assertEquals(false,config.isCacheGzippedContent());
}
@Test public void cacheShouldNotBeClearedAfterModelReload() throws IOException {
Assert.assertNotNull(cacheStrategy.get(new CacheKey("g3",ResourceType.CSS,true)));
Assert.assertNotNull(cacheStrategy.get(new CacheKey("g3",ResourceType.CSS,true)));
}
@Test public void shouldCreateValidCacheKeyWhenRequestContainsAllRequiredInfo(){
assertEquals(new CacheKey("g1",ResourceType.CSS,true),victim.create(mockRequest));
}
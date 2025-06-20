@Test public void shouldCreateNullCacheKeyWhenRequestDoesNotContainResourceType(){
assertNull(victim.create(mockRequest));
}
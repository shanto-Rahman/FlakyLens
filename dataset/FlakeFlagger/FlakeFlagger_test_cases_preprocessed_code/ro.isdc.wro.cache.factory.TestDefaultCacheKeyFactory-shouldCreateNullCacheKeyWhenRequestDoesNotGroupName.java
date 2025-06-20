@Test public void shouldCreateNullCacheKeyWhenRequestDoesNotGroupName(){
assertNull(victim.create(mockRequest));
}
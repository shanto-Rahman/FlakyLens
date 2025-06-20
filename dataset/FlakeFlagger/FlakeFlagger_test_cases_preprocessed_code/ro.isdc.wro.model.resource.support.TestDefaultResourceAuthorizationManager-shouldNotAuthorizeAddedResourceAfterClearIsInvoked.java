@Test public void shouldNotAuthorizeAddedResourceAfterClearIsInvoked(){
assertTrue(victim.isAuthorized(resource));
assertFalse(victim.isAuthorized(resource));
}
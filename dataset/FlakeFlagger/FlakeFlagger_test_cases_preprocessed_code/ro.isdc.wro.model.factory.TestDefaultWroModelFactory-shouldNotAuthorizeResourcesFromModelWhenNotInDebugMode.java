@Test public void shouldNotAuthorizeResourcesFromModelWhenNotInDebugMode(){
Assert.assertFalse(authManager.isAuthorized(authorizedResourceUri));
Assert.assertFalse(authManager.isAuthorized("/notAuthorized.js"));
}
@Test public void shouldAuthorizeResourcesFromModelWhenInDebugMode(){
Assert.assertTrue(authManager.isAuthorized(authorizedResourceUri));
Assert.assertFalse(authManager.isAuthorized("/notAuthorized.js"));
}
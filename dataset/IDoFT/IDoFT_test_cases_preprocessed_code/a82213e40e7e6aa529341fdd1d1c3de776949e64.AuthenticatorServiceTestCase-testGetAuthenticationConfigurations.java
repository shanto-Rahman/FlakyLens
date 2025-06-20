@Test public void testGetAuthenticationConfigurations() throws Exception {
Assert.assertEquals(responseOAuthDataObj,oAuthData);
Assert.assertEquals(responseEmptyOAuthDataObj,emptyOAuthDataObj);
Assert.assertEquals(e.getMessage(),"Error while creating the keys for OAuth application : store");
}
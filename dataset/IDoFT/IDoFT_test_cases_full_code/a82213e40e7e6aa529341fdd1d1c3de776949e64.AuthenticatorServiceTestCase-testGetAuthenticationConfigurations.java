@Test public void testGetAuthenticationConfigurations() throws Exception {
  SystemApplicationDao systemApplicationDao=Mockito.mock(SystemApplicationDao.class);
  Mockito.when(systemApplicationDao.isConsumerKeyExistForApplication("store")).thenReturn(false);
  APIMConfigurationService apimConfigurationService=Mockito.mock(APIMConfigurationService.class);
  EnvironmentConfigurations environmentConfigurations=new EnvironmentConfigurations();
  Mockito.when(apimConfigurationService.getEnvironmentConfigurations()).thenReturn(environmentConfigurations);
  APIMAppConfigurationService apimAppConfigurationService=Mockito.mock(APIMAppConfigurationService.class);
  APIMAppConfigurations apimAppConfigurations=new APIMAppConfigurations();
  Mockito.when(apimAppConfigurationService.getApimAppConfigurations()).thenReturn(apimAppConfigurations);
  OAuthApplicationInfo oAuthApplicationInfo=new OAuthApplicationInfo();
  oAuthApplicationInfo.setClientId("xxx-client-id-xxx");
  oAuthApplicationInfo.setCallBackURL("https://localhost/9292/login/callback/store");
  JsonObject oAuthData=new JsonObject();
  String scopes="apim:self-signup apim:dedicated_gateway apim:subscribe openid";
  oAuthData.addProperty(KeyManagerConstants.OAUTH_CLIENT_ID,oAuthApplicationInfo.getClientId());
  oAuthData.addProperty(KeyManagerConstants.OAUTH_CALLBACK_URIS,oAuthApplicationInfo.getCallBackURL());
  oAuthData.addProperty(KeyManagerConstants.TOKEN_SCOPES,scopes);
  oAuthData.addProperty(KeyManagerConstants.AUTHORIZATION_ENDPOINT,"https://localhost:9080/oauth2/authorize");
  oAuthData.addProperty(AuthenticatorConstants.SSO_ENABLED,ServiceReferenceHolder.getInstance().getAPIMAppConfiguration().isSsoEnabled());
  oAuthData.addProperty(AuthenticatorConstants.MULTI_ENVIRONMENT_OVERVIEW_ENABLED,APIMConfigurationService.getInstance().getEnvironmentConfigurations().getMultiEnvironmentOverview().isEnabled());
  MultiEnvironmentOverview multiEnvironmentOverview=new MultiEnvironmentOverview();
  environmentConfigurations.setMultiEnvironmentOverview(multiEnvironmentOverview);
  KeyManager keyManager=Mockito.mock(KeyManager.class);
  AuthenticatorService authenticatorService=new AuthenticatorService(keyManager,systemApplicationDao,apimConfigurationService,apimAppConfigurationService);
  Mockito.when(keyManager.createApplication(Mockito.any())).thenReturn(oAuthApplicationInfo);
  JsonObject responseOAuthDataObj=authenticatorService.getAuthenticationConfigurations("store");
  Assert.assertEquals(responseOAuthDataObj,oAuthData);
  JsonObject emptyOAuthDataObj=new JsonObject();
  Mockito.when(keyManager.createApplication(Mockito.any())).thenReturn(null);
  JsonObject responseEmptyOAuthDataObj=authenticatorService.getAuthenticationConfigurations("store");
  Assert.assertEquals(responseEmptyOAuthDataObj,emptyOAuthDataObj);
  Mockito.when(keyManager.createApplication(Mockito.any())).thenThrow(KeyManagementException.class);
  try {
    authenticatorService.getAuthenticationConfigurations("store");
  }
 catch (  APIManagementException e) {
    Assert.assertEquals(e.getMessage(),"Error while creating the keys for OAuth application : store");
  }
}

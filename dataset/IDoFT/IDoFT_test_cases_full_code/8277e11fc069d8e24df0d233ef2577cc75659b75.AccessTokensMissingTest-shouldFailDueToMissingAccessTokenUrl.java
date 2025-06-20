@Test public void shouldFailDueToMissingAccessTokenUrl(){
  exception.expect(hasFeature(Throwables::getRootCause,hasFeature("message",Throwable::getMessage,compose(containsString("riptide.oauth.access-token-url")).and(containsString("ACCESS_TOKEN_URL")))));
  new SpringApplicationBuilder(TestConfiguration.class).profiles("oauth").build().run();
}

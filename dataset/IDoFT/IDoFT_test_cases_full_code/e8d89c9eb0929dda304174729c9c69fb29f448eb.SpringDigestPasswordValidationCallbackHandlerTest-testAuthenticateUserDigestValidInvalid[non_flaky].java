@Test public void testAuthenticateUserDigestValidInvalid() throws Exception {
  User user=new User(username,"Big bird",true,true,true,true,Collections.<GrantedAuthority>emptyList());
  expect(userDetailsService.loadUserByUsername(username)).andReturn(user);
  replay(userDetailsService);
  callbackHandler.handleInternal(callback);
  boolean authenticated=callback.getResult();
  assertThat(authenticated).isFalse();
  assertThat(SecurityContextHolder.getContext().getAuthentication()).isNull();
  verify(userDetailsService);
}

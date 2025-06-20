@Test public void testAuthenticateUserDigestValidInvalid() throws Exception {
  User user=new User(username,"Big bird",true,true,true,true,Collections.<GrantedAuthority>emptyList());
  expect(userDetailsService.loadUserByUsername(username)).andReturn(user);
  replay(userDetailsService);
  callbackHandler.handleInternal(callback);
  boolean authenticated=callback.getResult();
  Assert.assertFalse("Authenticated",authenticated);
  Assert.assertNull("Authentication created",SecurityContextHolder.getContext().getAuthentication());
  verify(userDetailsService);
}

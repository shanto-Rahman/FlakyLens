@Test public void testAuthenticateUserDigestUserNotFound() throws Exception {
  expect(userDetailsService.loadUserByUsername(username)).andThrow(new UsernameNotFoundException(username));
  replay(userDetailsService);
  callbackHandler.handleInternal(callback);
  boolean authenticated=callback.getResult();
  Assert.assertFalse("Authenticated",authenticated);
  Assert.assertNull("Authentication created",SecurityContextHolder.getContext().getAuthentication());
  verify(userDetailsService);
}

@Test public void testAuthenticateUserDigestUserNotFound() throws Exception {
  expect(userDetailsService.loadUserByUsername(username)).andThrow(new UsernameNotFoundException(username));
  replay(userDetailsService);
  callbackHandler.handleInternal(callback);
  boolean authenticated=callback.getResult();
  assertThat(authenticated).isFalse();
  assertThat(SecurityContextHolder.getContext().getAuthentication()).isNull();
  verify(userDetailsService);
}

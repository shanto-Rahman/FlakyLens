@Test public void testAuthenticateUserDigestUserNotFound() throws Exception {
assertThat(authenticated).isFalse();
assertThat(SecurityContextHolder.getContext().getAuthentication()).isNull();
}
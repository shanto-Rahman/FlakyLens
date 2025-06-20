@Test public void testAuthenticateUserDigestValidInvalid() throws Exception {
assertThat(authenticated).isFalse();
assertThat(SecurityContextHolder.getContext().getAuthentication()).isNull();
}
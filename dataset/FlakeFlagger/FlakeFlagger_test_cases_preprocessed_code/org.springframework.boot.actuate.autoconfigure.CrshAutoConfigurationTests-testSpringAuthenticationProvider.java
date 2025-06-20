@Test public void testSpringAuthenticationProvider() throws Exception {
assertNotNull(authentication);
if (authentication.equals(plugin.getName())) {
}
assertTrue(authenticationPlugin.authenticate(SecurityConfiguration.USERNAME,SecurityConfiguration.PASSWORD));
assertFalse(authenticationPlugin.authenticate(UUID.randomUUID().toString(),SecurityConfiguration.PASSWORD));
}
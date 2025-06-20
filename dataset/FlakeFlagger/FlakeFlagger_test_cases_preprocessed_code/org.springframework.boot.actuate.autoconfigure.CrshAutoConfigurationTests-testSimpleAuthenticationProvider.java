@Test public void testSimpleAuthenticationProvider() throws Exception {
assertEquals("simple",lifeCycle.getConfig().get("crash.auth"));
assertNotNull(authentication);
if (authentication.equals(plugin.getName())) {
}
assertNotNull(authenticationPlugin);
assertTrue(authenticationPlugin.authenticate("user","password"));
assertFalse(authenticationPlugin.authenticate(UUID.randomUUID().toString(),"password"));
}
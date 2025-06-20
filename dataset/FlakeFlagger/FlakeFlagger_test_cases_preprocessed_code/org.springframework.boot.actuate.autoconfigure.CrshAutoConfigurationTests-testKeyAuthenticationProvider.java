@Test public void testKeyAuthenticationProvider(){
assertEquals("key",lifeCycle.getConfig().get("crash.auth"));
assertEquals("~/test.pem",lifeCycle.getConfig().get("crash.auth.key.path"));
}
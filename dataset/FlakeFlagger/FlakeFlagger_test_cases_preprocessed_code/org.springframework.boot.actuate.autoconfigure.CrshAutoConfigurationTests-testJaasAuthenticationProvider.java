@Test public void testJaasAuthenticationProvider(){
assertEquals("jaas",lifeCycle.getConfig().get("crash.auth"));
assertEquals("my-test-domain",lifeCycle.getConfig().get("crash.auth.jaas.domain"));
}
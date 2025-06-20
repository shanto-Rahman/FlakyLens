@Test public void testWebConfigurationInjectGlobalAuthentication() throws Exception {
assertNotNull(this.context.getBean(AuthenticationManagerBuilder.class));
assertNotNull(this.context.getBean(AuthenticationManager.class).authenticate(new UsernamePasswordAuthenticationToken("dave","secret")));
}
@Test public void testOverrideAuthenticationManager() throws Exception {
assertEquals(this.context.getBean(TestAuthenticationConfiguration.class).authenticationManager,this.context.getBean(AuthenticationManager.class));
}
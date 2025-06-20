@Test public void testOverrideAuthenticationManager() throws Exception {
assertEquals(this.context.getBean(TestConfiguration.class).authenticationManager,this.context.getBean(AuthenticationManager.class));
}
@Test public void testAuthenticationManagerCreated() throws Exception {
assertNotNull(this.context.getBean(AuthenticationManager.class));
}
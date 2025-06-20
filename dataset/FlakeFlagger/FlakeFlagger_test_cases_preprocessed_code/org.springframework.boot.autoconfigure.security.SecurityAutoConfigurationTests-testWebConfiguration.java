@Test public void testWebConfiguration() throws Exception {
assertNotNull(this.context.getBean(AuthenticationManagerBuilder.class));
assertEquals(5,filterChains.size());
}
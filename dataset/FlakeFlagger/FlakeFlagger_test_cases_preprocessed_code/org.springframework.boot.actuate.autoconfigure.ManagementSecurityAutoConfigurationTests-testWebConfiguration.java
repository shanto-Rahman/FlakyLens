@Test public void testWebConfiguration() throws Exception {
assertNotNull(this.context.getBean(AuthenticationManagerBuilder.class));
assertEquals(6,this.context.getBean(FilterChainProxy.class).getFilterChains().size());
}
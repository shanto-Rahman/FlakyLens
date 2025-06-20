@Test public void testDisableBasicAuthOnApplicationPaths() throws Exception {
assertEquals(6,this.context.getBean(FilterChainProxy.class).getFilterChains().size());
}
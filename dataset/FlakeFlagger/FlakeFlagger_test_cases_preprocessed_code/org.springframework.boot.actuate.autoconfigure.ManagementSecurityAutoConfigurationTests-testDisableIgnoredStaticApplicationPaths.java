@Test public void testDisableIgnoredStaticApplicationPaths() throws Exception {
assertEquals(2,this.context.getBean(FilterChainProxy.class).getFilterChains().size());
}
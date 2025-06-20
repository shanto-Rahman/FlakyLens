@Test public void testDisableIgnoredStaticApplicationPaths() throws Exception {
assertEquals(1,this.context.getBean(FilterChainProxy.class).getFilterChains().size());
}
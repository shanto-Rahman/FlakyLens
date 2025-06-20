@Test public void testDisableBasicAuthOnApplicationPaths() throws Exception {
assertEquals(1,this.context.getBeanNamesForType(FilterChainProxy.class).length);
}
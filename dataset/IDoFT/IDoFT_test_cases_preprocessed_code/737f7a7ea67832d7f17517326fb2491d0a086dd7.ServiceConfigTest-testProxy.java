@Test public void testProxy() throws Exception {
assertThat(service2.getExportedUrls(),hasSize(1));
assertEquals(2,TestProxyFactory.count);
}
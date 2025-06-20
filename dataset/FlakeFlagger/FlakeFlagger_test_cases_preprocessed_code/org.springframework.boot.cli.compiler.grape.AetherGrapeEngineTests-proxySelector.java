@Test public void proxySelector(){
assertTrue(session.getProxySelector() instanceof CompositeProxySelector);
}
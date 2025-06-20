@Test public void testGetServerSocketFactory() throws Exception {
assertNotNull(socketFactory);
assertTrue(ssl.isContextCreated());
assertTrue(parameters.isContextInjected());
}
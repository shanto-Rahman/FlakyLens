@Test public void testMetaInfAccessible() throws ClassNotFoundException {
ClassLoader cl=Thread.currentThread().getContextClassLoader();
assertNotNull(manifestResource);
}
@Test public void testNonMetaInfNotAccessible() throws ClassNotFoundException {
ClassLoader cl=Thread.currentThread().getContextClassLoader();
assertNull(nonManifestResource);
}
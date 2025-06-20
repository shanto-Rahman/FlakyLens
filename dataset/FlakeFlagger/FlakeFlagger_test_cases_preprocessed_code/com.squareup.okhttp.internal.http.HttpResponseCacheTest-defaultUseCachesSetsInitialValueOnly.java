@Test public void defaultUseCachesSetsInitialValueOnly() throws Exception {
assertTrue(c1.getDefaultUseCaches());
assertTrue(c1.getUseCaches());
assertTrue(c2.getUseCaches());
assertFalse(c3.getUseCaches());
}
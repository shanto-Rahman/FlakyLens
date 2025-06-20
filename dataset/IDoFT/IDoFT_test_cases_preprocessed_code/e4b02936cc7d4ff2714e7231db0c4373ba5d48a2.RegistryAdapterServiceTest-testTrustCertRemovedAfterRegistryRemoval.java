@Test public void testTrustCertRemovedAfterRegistryRemoval() throws Throwable {
assertEquals(1,trustCertInitialSize);
assertEquals(trustCertInitialSize,trustCertList.size());
assertEquals(trustCertInitialSize,trustCertList.size());
assertEquals(trustCertInitialSize - 1,trustCertList.size());
}
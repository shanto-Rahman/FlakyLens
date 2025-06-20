@Test public void linkDiscoverersCreated() throws Exception {
assertNotNull(discoverers);
assertTrue(HalLinkDiscoverer.class.isInstance(discoverer));
}
@Test public void testPatchSingleHostClusterWithPublicAddress() throws Throwable {
assertNotNull(cluster);
assertEquals(name,cluster.name);
assertEquals(details,cluster.details);
assertNull(cluster.publicAddress);
assertNotNull(patchClusterDto);
assertEquals(patchedAddress,cluster.publicAddress);
assertNotNull(cluster);
assertEquals(patchedAddress,cluster.publicAddress);
}
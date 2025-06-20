@Test public void testCreateClusterWithHostMapping() throws AmbariException {
fail("Expected create cluster to fail for invalid hosts");
fail("Expected to fail for non created cluster");
Assert.assertNotNull(clusters.getCluster("c1"));
}
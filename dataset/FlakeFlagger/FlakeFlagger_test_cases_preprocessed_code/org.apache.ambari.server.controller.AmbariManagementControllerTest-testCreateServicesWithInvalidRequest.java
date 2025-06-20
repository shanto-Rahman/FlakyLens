@Test public void testCreateServicesWithInvalidRequest() throws AmbariException {
fail("Expected failure for invalid requests");
fail("Expected failure for invalid requests");
fail("Expected failure for invalid cluster");
fail("Expected failure for invalid requests");
fail("Expected failure for invalid service");
fail("Expected failure for multiple clusters");
Assert.assertNotNull(clusters.getCluster("foo"));
Assert.assertEquals(0,clusters.getCluster("foo").getServices().size());
fail("Expected failure for existing service");
Assert.assertEquals(1,clusters.getCluster("foo").getServices().size());
}
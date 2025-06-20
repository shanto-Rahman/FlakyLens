@Test public void testCreateServicesMultiple() throws AmbariException {
fail("Expected failure for invalid services");
Assert.assertNotNull(clusters.getCluster("foo"));
Assert.assertEquals(2,clusters.getCluster("foo").getServices().size());
Assert.assertNotNull(clusters.getCluster("foo").getService("HDFS"));
Assert.assertNotNull(clusters.getCluster("foo").getService("MAPREDUCE"));
}
@Test public void testGetClusterResources() throws Exception {
Assert.assertEquals(5,resources.size());
Assert.assertEquals(name,"Cluster" + id);
Assert.assertEquals(1,resources.size());
Assert.assertEquals(102L,resources.iterator().next().getPropertyValue(ClusterResourceProvider.CLUSTER_ID_PROPERTY_ID));
Assert.assertEquals("Cluster102",resources.iterator().next().getPropertyValue(ClusterResourceProvider.CLUSTER_NAME_PROPERTY_ID));
Assert.assertEquals(1,resources.size());
Assert.assertEquals(103L,resources.iterator().next().getPropertyValue(ClusterResourceProvider.CLUSTER_ID_PROPERTY_ID));
Assert.assertEquals("Cluster103",resources.iterator().next().getPropertyValue(ClusterResourceProvider.CLUSTER_NAME_PROPERTY_ID));
}
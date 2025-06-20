@Test public void testGetServiceResources() throws Exception {
Assert.assertEquals(5,resources.size());
Assert.assertEquals("Cluster100",clusterName);
Assert.assertTrue(names.contains(serviceResponse.getServiceName()));
Assert.assertEquals(1,resources.size());
Assert.assertEquals("Cluster100",resources.iterator().next().getPropertyValue(ServiceResourceProvider.SERVICE_CLUSTER_NAME_PROPERTY_ID));
Assert.assertEquals("Service102",resources.iterator().next().getPropertyValue(ServiceResourceProvider.SERVICE_SERVICE_NAME_PROPERTY_ID));
Assert.assertEquals(3,resources.size());
Assert.assertEquals("Cluster100",clusterName);
Assert.assertTrue(names.contains(serviceResponse.getServiceName()));
}
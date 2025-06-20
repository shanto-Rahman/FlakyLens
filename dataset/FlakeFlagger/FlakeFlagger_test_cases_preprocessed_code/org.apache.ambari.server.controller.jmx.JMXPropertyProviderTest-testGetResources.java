@Test public void testGetResources() throws Exception {
Assert.assertEquals(1,propertyProvider.populateResources(Collections.singleton(resource),request,null).size());
Assert.assertEquals(propertyProvider.getSpec("ec2-50-17-129-192.compute-1.amazonaws.com:50070"),streamProvider.getLastSpec());
Assert.assertEquals(1084287,resource.getPropertyValue(PropertyHelper.getPropertyId("metrics/rpc","ReceivedBytes")));
Assert.assertEquals(173,resource.getPropertyValue(PropertyHelper.getPropertyId("metrics/dfs/namenode","CreateFileOps")));
Assert.assertEquals(405.8686,resource.getPropertyValue(PropertyHelper.getPropertyId("metrics/jvm","memHeapUsedM")));
Assert.assertEquals(propertyProvider.getSpec("ec2-23-23-71-42.compute-1.amazonaws.com:50075"),streamProvider.getLastSpec());
Assert.assertEquals(0,resource.getPropertyValue(PropertyHelper.getPropertyId("metrics/rpc","ReceivedBytes")));
Assert.assertEquals(16.870667,resource.getPropertyValue(PropertyHelper.getPropertyId("metrics/jvm","memHeapUsedM")));
Assert.assertEquals(propertyProvider.getSpec("ec2-23-23-71-42.compute-1.amazonaws.com:50030"),streamProvider.getLastSpec());
Assert.assertEquals(3,PropertyHelper.getProperties(resource).size());
Assert.assertEquals(59,resource.getPropertyValue(PropertyHelper.getPropertyId("metrics/jvm","threadsWaiting")));
Assert.assertNull(resource.getPropertyValue(PropertyHelper.getPropertyId("metrics/jvm","gcCount")));
}
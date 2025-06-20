@Test public void testCreateServiceComponentSimple() throws AmbariException {
fail("ServiceComponent creation should fail for invalid state");
fail("ServiceComponent creation should have failed");
Assert.assertNotNull(clusters.getCluster(clusterName).getService(serviceName).getServiceComponent(componentName));
Assert.assertEquals(1,response.size());
Assert.assertEquals(State.INIT.toString(),sc.getDesiredState());
Assert.assertEquals(componentName,sc.getComponentName());
Assert.assertEquals(clusterName,sc.getClusterName());
Assert.assertEquals(serviceName,sc.getServiceName());
}
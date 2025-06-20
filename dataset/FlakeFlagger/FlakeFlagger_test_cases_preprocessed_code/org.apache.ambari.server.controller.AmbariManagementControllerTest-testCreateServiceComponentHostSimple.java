@Test public void testCreateServiceComponentHostSimple() throws AmbariException {
fail("ServiceComponentHost creation should fail for invalid host" + " as host not mapped to cluster");
fail("ServiceComponentHost creation should fail for invalid state");
fail("ServiceComponentHost creation should have failed earlier");
fail("ServiceComponentHost creation should fail as duplicate");
Assert.assertNotNull(clusters.getCluster(clusterName).getService(serviceName).getServiceComponent(componentName1).getServiceComponentHost(host1));
Assert.assertNotNull(clusters.getCluster(clusterName).getService(serviceName).getServiceComponent(componentName2).getServiceComponentHost(host1));
Assert.assertNotNull(clusters.getCluster(clusterName).getService(serviceName).getServiceComponent(componentName2).getServiceComponentHost(host2));
Assert.assertNotNull(clusters.getCluster(clusterName).getService(serviceName).getServiceComponent(componentName3).getServiceComponentHost(host1));
Assert.assertNotNull(clusters.getCluster(clusterName).getService(serviceName).getServiceComponent(componentName3).getServiceComponentHost(host2));
Assert.assertEquals(2,response.size());
}
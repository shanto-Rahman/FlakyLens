@Test public void testCreateServiceComponentHostMultiple() throws AmbariException {
Assert.assertEquals(2,clusters.getCluster(clusterName).getServiceComponentHosts(host1).size());
Assert.assertEquals(2,clusters.getCluster(clusterName).getServiceComponentHosts(host2).size());
Assert.assertNotNull(clusters.getCluster(clusterName).getService(serviceName).getServiceComponent(componentName1).getServiceComponentHost(host1));
Assert.assertNotNull(clusters.getCluster(clusterName).getService(serviceName).getServiceComponent(componentName1).getServiceComponentHost(host2));
Assert.assertNotNull(clusters.getCluster(clusterName).getService(serviceName).getServiceComponent(componentName2).getServiceComponentHost(host1));
Assert.assertNotNull(clusters.getCluster(clusterName).getService(serviceName).getServiceComponent(componentName2).getServiceComponentHost(host2));
}
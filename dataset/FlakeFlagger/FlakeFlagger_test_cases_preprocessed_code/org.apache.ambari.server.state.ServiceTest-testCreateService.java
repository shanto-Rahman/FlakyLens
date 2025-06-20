@Test public void testCreateService() throws AmbariException {
Assert.assertNotNull(service);
Assert.assertEquals(serviceName,service.getName());
Assert.assertEquals(cluster.getClusterId(),service.getCluster().getClusterId());
Assert.assertEquals(cluster.getClusterName(),service.getCluster().getClusterName());
Assert.assertEquals(State.INIT,service.getDesiredState());
Assert.assertFalse(service.getDesiredStackVersion().getStackId().isEmpty());
}
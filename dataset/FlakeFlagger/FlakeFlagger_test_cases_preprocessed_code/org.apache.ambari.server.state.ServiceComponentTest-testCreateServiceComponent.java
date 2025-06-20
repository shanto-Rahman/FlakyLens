@Test public void testCreateServiceComponent() throws AmbariException {
Assert.assertNotNull(sc);
Assert.assertEquals(componentName,sc.getName());
Assert.assertEquals(serviceName,sc.getServiceName());
Assert.assertEquals(cluster.getClusterId(),sc.getClusterId());
Assert.assertEquals(cluster.getClusterName(),sc.getClusterName());
Assert.assertEquals(State.INIT,sc.getDesiredState());
Assert.assertFalse(sc.getDesiredStackVersion().getStackId().isEmpty());
}
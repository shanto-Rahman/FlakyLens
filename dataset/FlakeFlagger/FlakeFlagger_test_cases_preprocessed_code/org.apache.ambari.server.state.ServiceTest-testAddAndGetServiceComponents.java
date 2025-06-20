@Test public void testAddAndGetServiceComponents() throws AmbariException {
Assert.assertNotNull(service);
Assert.assertTrue(s.getServiceComponents().isEmpty());
Assert.assertEquals(2,s.getServiceComponents().size());
Assert.assertNotNull(s.getServiceComponent(sc1.getName()));
Assert.assertNotNull(s.getServiceComponent(sc2.getName()));
fail("Expected error when looking for invalid component");
Assert.assertNotNull(s.getServiceComponent(sc4.getName()));
Assert.assertEquals(State.INIT,s.getServiceComponent("HDFS_CLIENT").getDesiredState());
Assert.assertTrue(sc4.isClientComponent());
Assert.assertEquals(4,s.getServiceComponents().size());
Assert.assertNotNull(s.getServiceComponent(sc3.getName()));
Assert.assertEquals(sc3.getName(),s.getServiceComponent(sc3.getName()).getName());
Assert.assertEquals(s.getName(),s.getServiceComponent(sc3.getName()).getServiceName());
Assert.assertEquals(cluster.getClusterName(),s.getServiceComponent(sc3.getName()).getClusterName());
Assert.assertEquals(State.INSTALLING,s.getServiceComponent("HDFS_CLIENT").getDesiredState());
}
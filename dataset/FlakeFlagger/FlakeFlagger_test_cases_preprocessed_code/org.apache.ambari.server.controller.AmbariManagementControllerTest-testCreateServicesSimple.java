@Test public void testCreateServicesSimple() throws AmbariException {
Assert.assertNotNull(s);
Assert.assertEquals(serviceName,s.getName());
Assert.assertEquals(clusterName,s.getCluster().getClusterName());
Assert.assertEquals(1,r.size());
Assert.assertEquals(serviceName,resp.getServiceName());
Assert.assertEquals(clusterName,resp.getClusterName());
Assert.assertEquals(State.INIT.toString(),resp.getDesiredState());
Assert.assertEquals("HDP-0.1",resp.getDesiredStackVersion());
}
@Test public void testGetServiceComponentHosts() throws AmbariException {
Assert.assertEquals(1,resps.size());
Assert.assertEquals(c1.getClusterName(),resp.getClusterName());
Assert.assertEquals(sc1.getName(),resp.getComponentName());
Assert.assertEquals(s1.getName(),resp.getServiceName());
Assert.assertEquals(sch1.getHostName(),resp.getHostname());
Assert.assertEquals(sch1.getDesiredState().toString(),resp.getDesiredState());
Assert.assertEquals(sch1.getState().toString(),resp.getLiveState());
Assert.assertEquals(sch1.getStackVersion().getStackId(),resp.getStackVersion());
}
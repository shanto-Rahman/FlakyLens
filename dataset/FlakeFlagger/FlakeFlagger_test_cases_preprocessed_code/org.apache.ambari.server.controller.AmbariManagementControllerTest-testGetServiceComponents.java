@Test public void testGetServiceComponents() throws AmbariException {
Assert.assertEquals(1,resps.size());
Assert.assertEquals(c1.getClusterName(),resp.getClusterName());
Assert.assertEquals(sc1.getName(),resp.getComponentName());
Assert.assertEquals(s1.getName(),resp.getServiceName());
Assert.assertEquals("HDP-0.1",resp.getDesiredStackVersion());
Assert.assertEquals(sc1.getDesiredState().toString(),resp.getDesiredState());
Assert.assertEquals(c1.getClusterId(),resp.getClusterId().longValue());
}
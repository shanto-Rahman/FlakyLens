@Test public void testGetServices() throws AmbariException {
Assert.assertEquals(s1.getClusterId(),resp1.getClusterId().longValue());
Assert.assertEquals(s1.getCluster().getClusterName(),resp1.getClusterName());
Assert.assertEquals(s1.getName(),resp1.getServiceName());
Assert.assertEquals("HDP-0.1",s1.getDesiredStackVersion().getStackId());
Assert.assertEquals(s1.getDesiredStackVersion().getStackId(),resp1.getDesiredStackVersion());
Assert.assertEquals(State.INSTALLED.toString(),resp1.getDesiredState());
}
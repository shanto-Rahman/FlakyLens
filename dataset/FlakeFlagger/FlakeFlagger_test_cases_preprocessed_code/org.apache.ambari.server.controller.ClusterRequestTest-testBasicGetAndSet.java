@Test public void testBasicGetAndSet(){
Assert.assertEquals(clusterId,r1.getClusterId());
Assert.assertEquals(clusterName,r1.getClusterName());
Assert.assertEquals(stackVersion.getStackId(),r1.getStackVersion());
Assert.assertArrayEquals(hostNames.toArray(),r1.getHostNames().toArray());
Assert.assertEquals(clusterId,r1.getClusterId());
Assert.assertEquals("foo1",r1.getClusterName());
Assert.assertEquals("HDP-1.0.2",r1.getStackVersion());
Assert.assertArrayEquals(hostNames.toArray(),r1.getHostNames().toArray());
}
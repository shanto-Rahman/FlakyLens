@Test public void testBasicGetAndSet(){
Assert.assertEquals(clusterId,r1.getClusterId());
Assert.assertEquals(clusterName,r1.getClusterName());
Assert.assertArrayEquals(hostNames.toArray(),r1.getHostNames().toArray());
Assert.assertEquals("bar",r1.getDesiredStackVersion());
}
@Test public void testGetClusters() throws AmbariException {
Assert.assertEquals(1,resp.size());
Assert.assertEquals(c1.getClusterId(),resp1.getClusterId().longValue());
Assert.assertEquals(c1.getClusterName(),resp1.getClusterName());
Assert.assertEquals(c1.getDesiredStackVersion().getStackId(),resp1.getDesiredStackVersion());
}
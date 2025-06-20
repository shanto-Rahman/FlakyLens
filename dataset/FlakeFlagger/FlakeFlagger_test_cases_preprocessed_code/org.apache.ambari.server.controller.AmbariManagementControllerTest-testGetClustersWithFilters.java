@Test public void testGetClustersWithFilters() throws AmbariException {
Assert.assertEquals(4,resp.size());
Assert.assertEquals(1,resp.size());
Assert.assertEquals(c1.getClusterId(),resp.iterator().next().getClusterId().longValue());
Assert.assertEquals(2,resp.size());
Assert.assertEquals(1,resp.size());
Assert.assertEquals(c4.getClusterId(),resp.iterator().next().getClusterId().longValue());
}
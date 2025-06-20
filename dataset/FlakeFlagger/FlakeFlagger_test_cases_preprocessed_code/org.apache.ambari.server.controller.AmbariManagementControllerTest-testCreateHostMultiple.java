@Test public void testCreateHostMultiple() throws AmbariException {
Assert.assertEquals(2,clusters.getClustersForHost("h1").size());
Assert.assertEquals(2,clusters.getClustersForHost("h2").size());
Assert.assertEquals(0,clusters.getClustersForHost("h3").size());
Assert.assertEquals(2,clusters.getHost("h2").getHostAttributes().size());
Assert.assertEquals(2,clusters.getHost("h3").getHostAttributes().size());
Assert.assertEquals("val1",clusters.getHost("h2").getHostAttributes().get("attr1"));
Assert.assertEquals("val2",clusters.getHost("h2").getHostAttributes().get("attr2"));
}
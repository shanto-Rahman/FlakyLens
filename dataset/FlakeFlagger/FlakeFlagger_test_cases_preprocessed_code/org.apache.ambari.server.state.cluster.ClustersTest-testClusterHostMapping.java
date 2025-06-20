@Test public void testClusterHostMapping() throws AmbariException {
fail("Expected exception for invalid cluster/host");
Assert.assertNotNull(clusters.getCluster(c1));
Assert.assertNotNull(clusters.getCluster(c2));
fail("Expected exception for invalid host");
Assert.assertNotNull(clusters.getHost(h1));
Assert.assertEquals(0,c.size());
Assert.assertEquals(2,c.size());
Assert.assertEquals(2,c.size());
Assert.assertEquals(2,hostsForC1.size());
Assert.assertTrue(hostsForC1.containsKey(h1));
Assert.assertTrue(hostsForC1.containsKey(h2));
Assert.assertNotNull(hostsForC1.get(h1));
Assert.assertNotNull(hostsForC1.get(h2));
}
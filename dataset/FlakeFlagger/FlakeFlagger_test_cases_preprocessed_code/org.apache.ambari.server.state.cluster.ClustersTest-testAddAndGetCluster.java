@Test public void testAddAndGetCluster() throws AmbariException {
fail("Exception should be thrown on invalid add");
fail("Exception should be thrown on invalid add");
Assert.assertNotNull(clusters.getCluster(c1));
Assert.assertNotNull(clusters.getCluster(c2));
Assert.assertEquals(c1,clusters.getCluster(c1).getClusterName());
Assert.assertEquals(c2,clusters.getCluster(c2).getClusterName());
Assert.assertTrue(verifyClusters.containsKey(c1));
Assert.assertTrue(verifyClusters.containsKey(c2));
Assert.assertNotNull(verifyClusters.get(c1));
Assert.assertNotNull(verifyClusters.get(c2));
Assert.assertNotNull(changed);
Assert.assertEquals(cId,changed.getClusterId());
Assert.assertEquals("foobar",clusters.getClusterById(cId).getClusterName());
}
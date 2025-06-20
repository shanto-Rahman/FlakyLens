@Test public void testCreateClusterSimple() throws AmbariException {
Assert.assertEquals(1,r.size());
Assert.assertEquals(clusterName,c.getClusterName());
fail("Duplicate cluster creation should fail");
}
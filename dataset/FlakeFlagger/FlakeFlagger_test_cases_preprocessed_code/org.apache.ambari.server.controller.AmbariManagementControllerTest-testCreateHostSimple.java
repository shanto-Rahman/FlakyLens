@Test public void testCreateHostSimple() throws AmbariException {
fail("Create host should fail for non-bootstrapped host");
fail("Create host should fail for invalid clusters");
Assert.assertNotNull(clusters.getHost("h1"));
Assert.assertNotNull(clusters.getHost("h2"));
Assert.assertEquals(0,clusters.getClustersForHost("h1").size());
Assert.assertEquals(2,clusters.getClustersForHost("h2").size());
}
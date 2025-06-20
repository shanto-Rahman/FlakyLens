@Test public void testAddAndGetHost() throws AmbariException {
fail("Expected exception on duplicate host entry");
Assert.assertEquals(3,hosts.size());
Assert.assertNotNull(clusters.getHost(h1));
Assert.assertNotNull(clusters.getHost(h2));
Assert.assertNotNull(clusters.getHost(h3));
Assert.assertNotNull(h);
fail("Expected error for unknown host");
}
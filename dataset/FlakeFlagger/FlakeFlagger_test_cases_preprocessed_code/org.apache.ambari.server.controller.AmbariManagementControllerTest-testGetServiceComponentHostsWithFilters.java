@Test public void testGetServiceComponentHostsWithFilters() throws AmbariException {
fail("Expected failure for invalid cluster");
Assert.assertEquals(6,resps.size());
Assert.assertEquals(5,resps.size());
Assert.assertEquals(1,resps.size());
Assert.assertEquals(2,resps.size());
Assert.assertEquals(1,resps.size());
Assert.assertEquals(2,resps.size());
Assert.assertEquals(0,resps.size());
Assert.assertEquals(1,resps.size());
Assert.assertEquals(0,resps.size());
Assert.assertEquals(0,resps.size());
Assert.assertEquals(1,resps.size());
Assert.assertEquals(4,resps.size());
}
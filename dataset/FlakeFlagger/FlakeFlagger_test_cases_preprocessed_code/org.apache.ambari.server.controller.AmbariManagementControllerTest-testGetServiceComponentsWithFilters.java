@Test public void testGetServiceComponentsWithFilters() throws AmbariException {
fail("Expected failure for invalid cluster");
Assert.assertEquals(3,resps.size());
Assert.assertEquals(4,resps.size());
Assert.assertEquals(2,resps.size());
Assert.assertEquals(1,resps.size());
Assert.assertEquals(sc4.getName(),resps.iterator().next().getComponentName());
Assert.assertEquals(1,resps.size());
Assert.assertEquals(sc5.getName(),resps.iterator().next().getComponentName());
Assert.assertEquals(1,resps.size());
Assert.assertEquals(sc5.getName(),resps.iterator().next().getComponentName());
Assert.assertEquals(7,resps.size());
}
@Test public void testGetServicesWithFilters() throws AmbariException {
fail("Expected failure for invalid request");
Assert.assertEquals(3,resp.size());
Assert.assertEquals(1,resp.size());
Assert.assertEquals(s2.getName(),resp.iterator().next().getServiceName());
fail("Expected failure for invalid service");
Assert.assertEquals(2,resp.size());
Assert.assertEquals(1,resp.size());
Assert.assertEquals(3,resp.size());
}
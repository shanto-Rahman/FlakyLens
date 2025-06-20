@Test public void testCreateServiceComponentHostWithInvalidRequest() throws AmbariException {
fail("Expected failure for invalid requests");
fail("Expected failure for invalid requests");
fail("Expected failure for invalid requests");
fail("Expected failure for invalid requests");
fail("Expected failure for invalid cluster");
fail("Expected failure for invalid service");
fail("Expected failure for invalid service");
fail("Expected failure for invalid host");
fail("Expected failure for invalid host cluster mapping");
fail("Expected failure for dup requests");
fail("Expected failure for multiple clusters");
fail("Expected failure for already existing");
Assert.assertEquals(1,foo.getServiceComponentHosts("h1").size());
Assert.assertEquals(0,foo.getServiceComponentHosts("h2").size());
Assert.assertEquals(0,foo.getServiceComponentHosts("h3").size());
Assert.assertEquals(1,foo.getServiceComponentHosts("h1").size());
Assert.assertEquals(1,c1.getServiceComponentHosts("h1").size());
Assert.assertEquals(1,c2.getServiceComponentHosts("h1").size());
}
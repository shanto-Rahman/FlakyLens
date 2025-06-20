@Test public void testCreateServiceComponentWithInvalidRequest() throws AmbariException {
fail("Expected failure for invalid requests");
fail("Expected failure for invalid requests");
fail("Expected failure for invalid requests");
fail("Expected failure for invalid cluster");
fail("Expected failure for invalid service");
fail("Expected failure for dups in requests");
fail("Expected failure for multiple clusters");
fail("Expected failure for already existing component");
Assert.assertEquals(1,s1.getServiceComponents().size());
Assert.assertNotNull(s1.getServiceComponent("NAMENODE"));
Assert.assertEquals(2,s2.getServiceComponents().size());
Assert.assertNotNull(s2.getServiceComponent("JOBTRACKER"));
Assert.assertNotNull(s2.getServiceComponent("TASKTRACKER"));
}
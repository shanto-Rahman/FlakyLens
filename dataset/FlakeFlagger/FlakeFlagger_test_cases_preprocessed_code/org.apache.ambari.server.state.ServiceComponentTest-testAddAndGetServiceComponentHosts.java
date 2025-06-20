@Test public void testAddAndGetServiceComponentHosts() throws AmbariException {
Assert.assertNotNull(sc);
Assert.assertTrue(sc.getServiceComponentHosts().isEmpty());
fail("Expected error for invalid host");
fail("Expected error for dups");
Assert.assertTrue(sc.getServiceComponentHosts().isEmpty());
Assert.assertEquals(2,sc.getServiceComponentHosts().size());
Assert.assertNotNull(schCheck);
Assert.assertEquals("h2",schCheck.getHostName());
Assert.assertNotNull(sc.getServiceComponentHost("h3"));
Assert.assertNotNull(sch);
Assert.assertEquals(State.STARTING,sch.getState());
Assert.assertEquals(State.STARTED,sch.getDesiredState());
Assert.assertEquals("HDP-1.0.0",sch.getStackVersion().getStackId());
Assert.assertEquals("HDP-1.1.0",sch.getDesiredStackVersion().getStackId());
}
@Test public void testCreateServiceWithInvalidInfo() throws AmbariException {
fail("Service creation should fail for invalid state");
fail("Service creation should have failed");
fail("Service creation should fail for invalid initial state");
Assert.assertEquals(2,response.size());
Assert.assertTrue(svc.getServiceName().equals(serviceName) || svc.getServiceName().equals(serviceName2));
Assert.assertEquals("HDP-0.1",svc.getDesiredStackVersion());
Assert.assertEquals(State.INIT.toString(),svc.getDesiredState());
}
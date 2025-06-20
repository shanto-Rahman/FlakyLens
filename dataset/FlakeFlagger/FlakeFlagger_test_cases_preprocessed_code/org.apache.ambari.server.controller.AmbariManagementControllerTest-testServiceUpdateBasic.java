@Test public void testServiceUpdateBasic() throws AmbariException {
Assert.assertNotNull(s);
Assert.assertEquals(serviceName,s.getName());
Assert.assertEquals(State.INIT,s.getDesiredState());
Assert.assertEquals(clusterName,s.getCluster().getClusterName());
fail("Expected fail for invalid state transition");
Assert.assertNull(trackAction);
}
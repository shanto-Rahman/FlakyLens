@Test public void testSetHostState() throws AmbariException {
Assert.assertEquals(HostState.HEARTBEAT_LOST,clusters.getHost("h1").getState());
}
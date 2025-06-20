@Test public void testHostEvent() throws AmbariException, InvalidStateTransitionException {
Assert.assertEquals(HostState.WAITING_FOR_HOST_STATUS_UPDATES,clusters.getHost("h1").getState());
fail("Exception should be thrown on invalid event");
}
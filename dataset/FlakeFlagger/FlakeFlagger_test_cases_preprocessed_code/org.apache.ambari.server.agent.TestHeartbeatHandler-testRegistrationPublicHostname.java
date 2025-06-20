@Test public void testRegistrationPublicHostname() throws AmbariException, InvalidStateTransitionException {
assertEquals(hostObject.getState(),HostState.HEALTHY);
assertEquals("centos5",hostObject.getOsType());
assertTrue(hostObject.getLastRegistrationTime() != 0);
assertEquals(hostObject.getLastHeartbeatTime(),hostObject.getLastRegistrationTime());
assertEquals(verifyHost.getPublicHostName(),reg.getPublicHostname());
}
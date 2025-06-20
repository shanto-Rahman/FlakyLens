@Test public void testRegisterNewNode() throws AmbariException, InvalidStateTransitionException {
assertEquals(hostObject.getState(),HostState.HEALTHY);
assertEquals("redhat5",hostObject.getOsType());
assertEquals(RegistrationStatus.OK,response.getResponseStatus());
assertEquals(0,response.getResponseId());
assertTrue(response.getStatusCommands().isEmpty());
}
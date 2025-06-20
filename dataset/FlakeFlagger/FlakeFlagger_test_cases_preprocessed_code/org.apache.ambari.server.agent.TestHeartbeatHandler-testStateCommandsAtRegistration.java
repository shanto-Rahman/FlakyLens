@Test public void testStateCommandsAtRegistration() throws AmbariException, InvalidStateTransitionException {
assertTrue(registrationResponse.getStatusCommands().size() == 1);
assertTrue(registrationResponse.getStatusCommands().get(0).equals(statusCmd1));
}
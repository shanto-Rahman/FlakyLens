@Test public void testRequestId() throws IOException, InvalidStateTransitionException, JsonGenerationException, JAXBException {
assertEquals("ResponseId should start from zero",0L,registrationResponse.getResponseId());
assertEquals("responseId was not incremented",1L,hbResponse.getResponseId());
assertTrue("Not cached response returned",hbResponse == heartBeatHandler.handleHeartBeat(heartBeat));
assertEquals("responseId was not incremented",2L,hbResponse.getResponseId());
assertFalse("Agent is flagged for restart",hbResponse.isRestartAgent());
assertTrue("Agent is not flagged for restart",hbResponse.isRestartAgent());
}
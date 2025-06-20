@Test public void testTransferOneFile() throws Exception {
assertEquals(1,flowFileSent);
assertEquals(2,provenanceEvents.size());
assertEquals(ProvenanceEventType.SEND,provenanceEvent.getEventType());
assertEquals(endpointUri,provenanceEvent.getTransitUri());
assertEquals("Remote Host=peer-host, Remote DN=unit-test",provenanceEvent.getDetails());
}
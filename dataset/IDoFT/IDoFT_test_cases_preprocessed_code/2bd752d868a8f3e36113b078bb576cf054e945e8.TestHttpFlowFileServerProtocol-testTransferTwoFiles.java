@Test public void testTransferTwoFiles() throws Exception {
assertEquals(2,flowFileSent);
assertEquals(4,provenanceEvents.size());
assertEquals(ProvenanceEventType.SEND,provenanceEvent.getEventType());
assertEquals(endpointUri,provenanceEvent.getTransitUri());
assertEquals("Remote Host=peer-host, Remote DN=unit-test",provenanceEvent.getDetails());
assertEquals(ProvenanceEventType.DROP,provenanceEvent.getEventType());
}
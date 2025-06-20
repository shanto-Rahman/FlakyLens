@Test public void testTransferTwoFiles() throws Exception {
  final String transactionId="testTransferTwoFiles";
  final Peer peer=getDefaultPeer(transactionId);
  final String endpointUri="https://remote-host:8443/nifi-api/output-ports/port-id/transactions/" + transactionId + "/flow-files";
  final HttpFlowFileServerProtocol serverProtocol=getDefaultHttpFlowFileServerProtocol();
  final HttpServerCommunicationsSession commsSession=(HttpServerCommunicationsSession)peer.getCommunicationsSession();
  commsSession.putHandshakeParam(HandshakeProperty.BATCH_COUNT,"2");
  commsSession.setUserDn("unit-test");
  commsSession.setDataTransferUrl(endpointUri);
  transferFlowFiles(serverProtocol,transactionId,peer,processSession -> IntStream.of(1,2).mapToObj(i -> {
    final MockFlowFile flowFile=processSession.createFlowFile(("Server content " + i).getBytes());
    final HashMap<String,String> attributes=new HashMap<>();
    attributes.put("uuid","server-uuid-" + i);
    attributes.put("filename","server-filename-" + i);
    attributes.put("server-attr-" + i + "-1","server-attr-" + i + "-1-value");
    attributes.put("server-attr-" + i + "-2","server-attr-" + i + "-2-value");
    flowFile.putAttributes(attributes);
    return flowFile;
  }
).collect(Collectors.toList()));
  final int flowFileSent=serverProtocol.commitTransferTransaction(peer,"3058746557");
  assertEquals(2,flowFileSent);
  final List<ProvenanceEventRecord> provenanceEvents=sessionState.getProvenanceEvents();
  assertEquals(4,provenanceEvents.size());
  for (int i=0; i < provenanceEvents.size(); i+=2) {
    ProvenanceEventRecord provenanceEvent=provenanceEvents.get(i);
    assertEquals(ProvenanceEventType.SEND,provenanceEvent.getEventType());
    assertEquals(endpointUri,provenanceEvent.getTransitUri());
    assertEquals("Remote Host=peer-host, Remote DN=unit-test",provenanceEvent.getDetails());
    provenanceEvent=provenanceEvents.get(i + 1);
    assertEquals(ProvenanceEventType.DROP,provenanceEvent.getEventType());
  }
}

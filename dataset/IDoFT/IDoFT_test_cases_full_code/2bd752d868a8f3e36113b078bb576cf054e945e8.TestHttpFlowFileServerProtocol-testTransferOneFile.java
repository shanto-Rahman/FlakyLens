@Test public void testTransferOneFile() throws Exception {
  final HttpFlowFileServerProtocol serverProtocol=getDefaultHttpFlowFileServerProtocol();
  final String transactionId="testTransferOneFile";
  final Peer peer=getDefaultPeer(transactionId);
  final HttpServerCommunicationsSession commsSession=(HttpServerCommunicationsSession)peer.getCommunicationsSession();
  final String endpointUri="https://remote-host:8443/nifi-api/output-ports/port-id/transactions/" + transactionId + "/flow-files";
  commsSession.putHandshakeParam(HandshakeProperty.BATCH_COUNT,"1");
  commsSession.setUserDn("unit-test");
  commsSession.setDataTransferUrl(endpointUri);
  transferFlowFiles(serverProtocol,transactionId,peer,processSession -> {
    final MockFlowFile flowFile=processSession.createFlowFile("Server content".getBytes());
    final HashMap<String,String> attributes=new HashMap<>();
    attributes.put("uuid","server-uuid");
    attributes.put("filename","server-filename");
    attributes.put("server-attr-1","server-attr-1-value");
    attributes.put("server-attr-2","server-attr-2-value");
    flowFile.putAttributes(attributes);
    return Arrays.asList(flowFile);
  }
);
  final int flowFileSent=serverProtocol.commitTransferTransaction(peer,"3229577812");
  assertEquals(1,flowFileSent);
  final List<ProvenanceEventRecord> provenanceEvents=sessionState.getProvenanceEvents();
  assertEquals(2,provenanceEvents.size());
  final ProvenanceEventRecord provenanceEvent=provenanceEvents.get(0);
  assertEquals(ProvenanceEventType.SEND,provenanceEvent.getEventType());
  assertEquals(endpointUri,provenanceEvent.getTransitUri());
  assertEquals("Remote Host=peer-host, Remote DN=unit-test",provenanceEvent.getDetails());
}

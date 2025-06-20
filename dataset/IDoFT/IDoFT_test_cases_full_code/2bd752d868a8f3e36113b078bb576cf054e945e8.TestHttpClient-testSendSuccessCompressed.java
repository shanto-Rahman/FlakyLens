@Test public void testSendSuccessCompressed() throws Exception {
  try (SiteToSiteClient client=getDefaultBuilder().portName("input-running").useCompression(true).build()){
    final Transaction transaction=client.createTransaction(TransferDirection.SEND);
    assertNotNull(transaction);
    serverChecksum="1071206772";
    for (int i=0; i < 20; i++) {
      DataPacket packet=new DataPacketBuilder().contents("Example contents from client.").attr("Client attr 1","Client attr 1 value").attr("Client attr 2","Client attr 2 value").build();
      transaction.send(packet);
      long written=((Peer)transaction.getCommunicant()).getCommunicationsSession().getBytesWritten();
      logger.info("{}: {} bytes have been written.",i,written);
    }
    transaction.confirm();
    transaction.complete();
  }
 }

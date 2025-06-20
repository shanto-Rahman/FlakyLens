@Test public void testSendSlowClientSuccess() throws Exception {
  try (SiteToSiteClient client=getDefaultBuilder().idleExpiration(1000,TimeUnit.MILLISECONDS).portName("input-running").build()){
    final Transaction transaction=client.createTransaction(TransferDirection.SEND);
    assertNotNull(transaction);
    serverChecksum="3882825556";
    for (int i=0; i < 3; i++) {
      DataPacket packet=new DataPacketBuilder().contents("Example contents from client.").attr("Client attr 1","Client attr 1 value").attr("Client attr 2","Client attr 2 value").build();
      transaction.send(packet);
      long written=((Peer)transaction.getCommunicant()).getCommunicationsSession().getBytesWritten();
      logger.info("{} bytes have been written.",written);
      Thread.sleep(50);
    }
    transaction.confirm();
    transaction.complete();
  }
 }

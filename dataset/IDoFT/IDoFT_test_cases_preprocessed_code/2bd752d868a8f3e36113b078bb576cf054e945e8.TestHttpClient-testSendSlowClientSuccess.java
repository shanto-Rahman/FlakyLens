@Test public void testSendSlowClientSuccess() throws Exception {
assertNotNull(transaction);
serverChecksum="3882825556";//RW
DataPacket packet=new DataPacketBuilder().contents("Example contents from client.").attr("Client attr 1","Client attr 1 value").attr("Client attr 2","Client attr 2 value").build();//IT
Thread.sleep(50);
}
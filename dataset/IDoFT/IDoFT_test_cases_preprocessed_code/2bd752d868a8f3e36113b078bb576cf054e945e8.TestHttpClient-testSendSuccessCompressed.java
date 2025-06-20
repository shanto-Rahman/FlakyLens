@Test public void testSendSuccessCompressed() throws Exception {
assertNotNull(transaction);
serverChecksum="1071206772";//RW
DataPacket packet=new DataPacketBuilder().contents("Example contents from client.").attr("Client attr 1","Client attr 1 value").attr("Client attr 2","Client attr 2 value").build();//IT
}
@Test public void testReconnect() throws RemotingException, InterruptedException {
Assert.assertEquals(false,client.isConnected());
Thread.sleep(10);
Assert.assertEquals(true,client.isConnected());
Assert.assertEquals(false,client.isConnected());
Thread.sleep(200);
Assert.assertEquals(false,client.isConnected());
}
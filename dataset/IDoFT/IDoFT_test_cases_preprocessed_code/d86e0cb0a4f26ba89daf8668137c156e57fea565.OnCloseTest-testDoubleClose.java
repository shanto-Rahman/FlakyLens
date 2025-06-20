@Test public void testDoubleClose() throws DeploymentException {
client.connectToServer(new Endpoint()//RW
session.getBasicRemote().sendText("message");//RW
client.connectToServer(new Endpoint()//RW
messageLatch.countDown();
messageLatch.await(2,TimeUnit.SECONDS);
assertEquals(0,messageLatch.getCount());
}
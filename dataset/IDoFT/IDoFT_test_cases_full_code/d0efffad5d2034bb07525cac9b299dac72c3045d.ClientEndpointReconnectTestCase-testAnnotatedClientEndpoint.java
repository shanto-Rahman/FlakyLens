@Test public void testAnnotatedClientEndpoint() throws Exception {
  AnnotatedClientReconnectEndpoint endpoint=new AnnotatedClientReconnectEndpoint();
  Session session=deployment.connectToServer(endpoint,new URI("ws://" + DefaultServer.getHostAddress("default") + ":"+ DefaultServer.getHostPort("default")+ "/ws/"));
  Assert.assertEquals("OPEN",endpoint.message());
  session.getBasicRemote().sendText("hi");
  Assert.assertEquals("MESSAGE-ECHO-hi",endpoint.message());
  session.getBasicRemote().sendText("close");
  Assert.assertEquals("CLOSE",endpoint.message());
  Assert.assertEquals("OPEN",endpoint.message());
  session.getBasicRemote().sendText("hi");
  Assert.assertEquals("MESSAGE-ECHO-hi",endpoint.message());
  session.getBasicRemote().sendText("close");
  Assert.assertEquals("CLOSE",endpoint.message());
  Assert.assertEquals("OPEN",endpoint.message());
  session.getBasicRemote().sendText("hi");
  Assert.assertEquals("MESSAGE-ECHO-hi",endpoint.message());
  session.getBasicRemote().sendText("close");
  Assert.assertEquals("CLOSE",endpoint.message());
  Assert.assertNull(endpoint.quickMessage());
  Assert.assertFalse(failed);
}

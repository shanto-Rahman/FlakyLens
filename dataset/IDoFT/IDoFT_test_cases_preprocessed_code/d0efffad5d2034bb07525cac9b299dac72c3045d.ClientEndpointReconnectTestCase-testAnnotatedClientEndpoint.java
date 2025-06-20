@Test public void testAnnotatedClientEndpoint() throws Exception {
Session session=deployment.connectToServer(endpoint,new URI("ws://" + DefaultServer.getHostAddress("default") + ":"+ DefaultServer.getHostPort("default")+ "/ws/"));//RW
Assert.assertEquals("OPEN",endpoint.message());
Assert.assertEquals("MESSAGE-ECHO-hi",endpoint.message());
Assert.assertEquals("CLOSE",endpoint.message());
Assert.assertEquals("OPEN",endpoint.message());
Assert.assertEquals("MESSAGE-ECHO-hi",endpoint.message());
Assert.assertEquals("CLOSE",endpoint.message());
Assert.assertEquals("OPEN",endpoint.message());
Assert.assertEquals("MESSAGE-ECHO-hi",endpoint.message());
Assert.assertEquals("CLOSE",endpoint.message());
Assert.assertNull(endpoint.quickMessage());
Assert.assertFalse(failed);//RW
}
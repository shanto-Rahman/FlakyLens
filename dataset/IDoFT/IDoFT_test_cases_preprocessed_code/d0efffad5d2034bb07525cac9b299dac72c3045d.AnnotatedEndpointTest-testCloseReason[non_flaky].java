@Test public void testCloseReason() throws Exception {
Session session=deployment.connectToServer(AnnotatedClientEndpoint.class,new URI("ws://" + DefaultServer.getHostAddress("default") + ":"+ DefaultServer.getHostPort("default")+ "/ws/chat/Bob"));//RW
Assert.assertEquals("hi Bob (protocol=foo)",AnnotatedClientEndpoint.message());
Assert.assertEquals("CLOSED",AnnotatedClientEndpoint.message());
Assert.assertEquals(CloseReason.CloseCodes.VIOLATED_POLICY.getCode(),cr.getCloseCode().getCode());
Assert.assertEquals("Foo!",cr.getReasonPhrase());
}
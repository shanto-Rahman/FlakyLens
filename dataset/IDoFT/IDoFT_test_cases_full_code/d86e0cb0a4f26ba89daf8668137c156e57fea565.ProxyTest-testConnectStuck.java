/** 
 * Tests a situation when a client sends CONNECT to a proxy, but does not receive any reply.
 */
@Ignore @Test public void testConnectStuck() throws IOException {
  GrizzlyModProxy proxy=new GrizzlyModProxy(PROXY_IP,PROXY_PORT){
    @Override protected NextAction handleConnect(    final FilterChainContext ctx,    final HttpContent content){
      return ctx.getStopAction();
    }
  }
;
  proxy.start();
  try {
    ClientManager client=createClient();
    Map<String,Object> properties=client.getProperties();
    properties.put(ClientProperties.PROXY_URI,PROXY_URL);
    properties.put(ClientProperties.HANDSHAKE_TIMEOUT,200);
    try {
      client.connectToServer(new AnnotatedClientEndpoint(new CountDownLatch(1)),getURI(AnnotatedServerEndpoint.class));
      fail();
    }
 catch (    DeploymentException e) {
      assertTrue(e.getMessage().contains("Handshake response not received"));
    }
  }
  finally {
    proxy.stop();
  }
}

@Test public void testClientFallback(){
  final String url="/test/hello";
  final String resourceName="GET:" + url;
  configureRulesFor(resourceName,0);
  Response response=SentinelJaxRsClientTemplate.execute(resourceName,new Supplier<Response>(){
    @Override public Response get(){
      return client.target(host).path(url).request().get();
    }
  }
);
  assertEquals(javax.ws.rs.core.Response.Status.TOO_MANY_REQUESTS.getStatusCode(),response.getStatus());
  assertEquals("Blocked by Sentinel (flow limiting)",response.readEntity(String.class));
  ClusterNode cn=ClusterBuilderSlot.getClusterNode(resourceName);
  assertNotNull(cn);
  assertEquals(0,cn.passQps(),0.01);
}

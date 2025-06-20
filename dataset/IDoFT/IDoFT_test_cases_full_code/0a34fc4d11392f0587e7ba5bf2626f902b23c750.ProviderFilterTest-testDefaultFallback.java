@Test public void testDefaultFallback(){
  String url="/test/hello";
  String resourceName="GET:" + url;
  configureRulesFor(resourceName,0);
  Response response=given().get(url);
  response.then().statusCode(javax.ws.rs.core.Response.Status.TOO_MANY_REQUESTS.getStatusCode()).body(equalTo("Blocked by Sentinel (flow limiting)"));
  ClusterNode cn=ClusterBuilderSlot.getClusterNode(resourceName);
  assertNotNull(cn);
  assertEquals(0,cn.passQps(),0.01);
}

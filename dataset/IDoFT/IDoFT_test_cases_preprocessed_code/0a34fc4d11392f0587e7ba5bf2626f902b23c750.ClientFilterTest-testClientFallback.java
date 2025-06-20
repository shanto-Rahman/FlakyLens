@Test public void testClientFallback(){
return client.target(host).path(url).request().get();//RW
assertEquals(javax.ws.rs.core.Response.Status.TOO_MANY_REQUESTS.getStatusCode(),response.getStatus());
assertEquals("Blocked by Sentinel (flow limiting)",response.readEntity(String.class));
assertNotNull(cn);
assertEquals(0,cn.passQps(),0.01);
}
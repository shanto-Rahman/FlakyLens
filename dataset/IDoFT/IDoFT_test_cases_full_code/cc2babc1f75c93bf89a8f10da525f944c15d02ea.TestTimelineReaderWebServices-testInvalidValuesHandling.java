@Test public void testInvalidValuesHandling() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app?flowrunid=a23b");
    verifyHttpResponse(client,uri,Status.BAD_REQUEST);
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/timeline/"+ "clusters/cluster1/apps/app1/entities/app/id_1?flowrunid=2ab15");
    verifyHttpResponse(client,uri,Status.BAD_REQUEST);
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/timeline/"+ "clusters/cluster1/apps/app1/entities/app?limit=#$561av");
    verifyHttpResponse(client,uri,Status.BAD_REQUEST);
  }
  finally {
    client.destroy();
  }
}

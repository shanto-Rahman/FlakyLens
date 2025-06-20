@Test public void testGetEntityNotPresent() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app/id_10");
    verifyHttpResponse(client,uri,Status.NOT_FOUND);
  }
  finally {
    client.destroy();
  }
}

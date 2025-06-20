@Test public void testGetContainer() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/"+ "entities/YARN_CONTAINER/container_2_2");
    ClientResponse resp=getResponse(client,uri);
    TimelineEntity entities1=resp.getEntity(new GenericType<TimelineEntity>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities1);
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/containers/container_2_2");
    resp=getResponse(client,uri);
    TimelineEntity entities2=resp.getEntity(new GenericType<TimelineEntity>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON_TYPE,resp.getType());
    assertNotNull(entities2);
    assertEquals(entities1,entities2);
  }
  finally {
    client.destroy();
  }
}

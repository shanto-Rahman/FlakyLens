@Test public void testQueryWithoutCluster() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/apps/app1/entities/app/id_1");
    ClientResponse resp=getResponse(client,uri);
    TimelineEntity entity=resp.getEntity(TimelineEntity.class);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entity);
    assertEquals("id_1",entity.getId());
    assertEquals("app",entity.getType());
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/apps/app1/entities/app");
    resp=getResponse(client,uri);
    Set<TimelineEntity> entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(4,entities.size());
  }
  finally {
    client.destroy();
  }
}

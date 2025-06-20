@Test public void testGetEntityCustomFields() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app/id_1?"+ "fields=CONFIGS,Metrics,info");
    ClientResponse resp=getResponse(client,uri);
    TimelineEntity entity=resp.getEntity(TimelineEntity.class);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entity);
    assertEquals("id_1",entity.getId());
    assertEquals("app",entity.getType());
    assertEquals(3,entity.getConfigs().size());
    assertEquals(3,entity.getMetrics().size());
    assertTrue("UID should be present",entity.getInfo().containsKey(TimelineReaderUtils.UID_KEY));
    assertEquals(3,entity.getInfo().size());
    assertEquals(0,entity.getEvents().size());
  }
  finally {
    client.destroy();
  }
}

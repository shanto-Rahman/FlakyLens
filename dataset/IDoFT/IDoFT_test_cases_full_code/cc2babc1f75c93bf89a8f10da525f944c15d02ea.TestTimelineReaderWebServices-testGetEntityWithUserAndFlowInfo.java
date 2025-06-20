@Test public void testGetEntityWithUserAndFlowInfo() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app/id_1?"+ "userid=user1&flowname=flow1&flowrunid=1");
    ClientResponse resp=getResponse(client,uri);
    TimelineEntity entity=resp.getEntity(TimelineEntity.class);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entity);
    assertEquals("id_1",entity.getId());
    assertEquals("app",entity.getType());
    assertEquals((Long)1425016502000L,entity.getCreatedTime());
  }
  finally {
    client.destroy();
  }
}

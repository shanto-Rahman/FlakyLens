@Test public void testGetEntities() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app");
    ClientResponse resp=getResponse(client,uri);
    Set<TimelineEntity> entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(4,entities.size());
    assertTrue("Entities id_1, id_2, id_3 and id_4 should have been" + " present in response",entities.contains(newEntity("app","id_1")) && entities.contains(newEntity("app","id_2")) && entities.contains(newEntity("app","id_3"))&& entities.contains(newEntity("app","id_4")));
  }
  finally {
    client.destroy();
  }
}

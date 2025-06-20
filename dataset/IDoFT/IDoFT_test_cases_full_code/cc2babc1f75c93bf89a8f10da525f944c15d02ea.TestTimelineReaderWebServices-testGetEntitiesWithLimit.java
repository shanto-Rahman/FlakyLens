@Test public void testGetEntitiesWithLimit() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app?limit=2");
    ClientResponse resp=getResponse(client,uri);
    Set<TimelineEntity> entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(2,entities.size());
    assertTrue("Entities with id_1 and id_4 should have been present " + "in response based on entity created time.",entities.contains(newEntity("app","id_1")) && entities.contains(newEntity("app","id_4")));
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/timeline/"+ "clusters/cluster1/apps/app1/entities/app?limit=3");
    resp=getResponse(client,uri);
    entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(3,entities.size());
  }
  finally {
    client.destroy();
  }
}

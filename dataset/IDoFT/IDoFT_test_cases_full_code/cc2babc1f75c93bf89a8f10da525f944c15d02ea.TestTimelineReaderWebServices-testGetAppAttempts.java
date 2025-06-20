@Test public void testGetAppAttempts() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/"+ "entities/YARN_APPLICATION_ATTEMPT");
    ClientResponse resp=getResponse(client,uri);
    Set<TimelineEntity> entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    int totalEntities=entities.size();
    assertEquals(2,totalEntities);
    assertTrue("Entity with app-attempt-2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_APPLICATION_ATTEMPT.toString(),"app-attempt-1")));
    assertTrue("Entity with app-attempt-2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_APPLICATION_ATTEMPT.toString(),"app-attempt-2")));
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/appattempts");
    resp=getResponse(client,uri);
    entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON_TYPE,resp.getType());
    assertNotNull(entities);
    int retrievedEntity=entities.size();
    assertEquals(2,retrievedEntity);
    assertTrue("Entity with app-attempt-2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_APPLICATION_ATTEMPT.toString(),"app-attempt-1")));
    assertTrue("Entity with app-attempt-2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_APPLICATION_ATTEMPT.toString(),"app-attempt-2")));
    assertEquals(totalEntities,retrievedEntity);
  }
  finally {
    client.destroy();
  }
}

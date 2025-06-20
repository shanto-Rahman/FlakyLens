@Test public void testGetContainers() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/YARN_CONTAINER");
    ClientResponse resp=getResponse(client,uri);
    Set<TimelineEntity> entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    int totalEntities=entities.size();
    assertEquals(3,totalEntities);
    assertTrue("Entity with container_1_1 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_1_1")));
    assertTrue("Entity with container_2_1 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_2_1")));
    assertTrue("Entity with container_2_2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_2_2")));
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/"+ "appattempts/app-attempt-1/containers");
    resp=getResponse(client,uri);
    entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON_TYPE,resp.getType());
    assertNotNull(entities);
    int retrievedEntity=entities.size();
    assertEquals(1,retrievedEntity);
    assertTrue("Entity with container_1_1 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_1_1")));
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/"+ "appattempts/app-attempt-2/containers");
    resp=getResponse(client,uri);
    entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON_TYPE,resp.getType());
    assertNotNull(entities);
    retrievedEntity+=entities.size();
    assertEquals(2,entities.size());
    assertTrue("Entity with container_2_1 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_2_1")));
    assertTrue("Entity with container_2_2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_2_2")));
    assertEquals(totalEntities,retrievedEntity);
  }
  finally {
    client.destroy();
  }
}

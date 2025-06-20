@Test public void testGetEntitiesByRelations() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app?relatesto="+ "flow:flow1");
    ClientResponse resp=getResponse(client,uri);
    Set<TimelineEntity> entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(1,entities.size());
    assertTrue("Entity with id_1 should have been present in response.",entities.contains(newEntity("app","id_1")));
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/timeline/"+ "clusters/cluster1/apps/app1/entities/app?isrelatedto="+ "type1:tid1_2,type2:tid2_1%60");
    resp=getResponse(client,uri);
    entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(1,entities.size());
    assertTrue("Entity with id_1 should have been present in response.",entities.contains(newEntity("app","id_1")));
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/timeline/"+ "clusters/cluster1/apps/app1/entities/app?isrelatedto="+ "type1:tid1_1:tid1_2,type2:tid2_1%60");
    resp=getResponse(client,uri);
    entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(1,entities.size());
    assertTrue("Entity with id_1 should have been present in response.",entities.contains(newEntity("app","id_1")));
  }
  finally {
    client.destroy();
  }
}

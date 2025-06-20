@Test public void testGetEntitiesBasedOnCreatedTime() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app?"+ "createdtimestart=1425016502030&createdtimeend=1425016502060");
    ClientResponse resp=getResponse(client,uri);
    Set<TimelineEntity> entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(1,entities.size());
    assertTrue("Entity with id_4 should have been present in response.",entities.contains(newEntity("app","id_4")));
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/timeline/"+ "clusters/cluster1/apps/app1/entities/app?createdtimeend"+ "=1425016502010");
    resp=getResponse(client,uri);
    entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(3,entities.size());
    assertFalse("Entity with id_4 should not have been present in response.",entities.contains(newEntity("app","id_4")));
    uri=URI.create("http://localhost:" + serverPort + "/ws/v2/timeline/"+ "clusters/cluster1/apps/app1/entities/app?createdtimestart="+ "1425016502010");
    resp=getResponse(client,uri);
    entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(1,entities.size());
    assertTrue("Entity with id_4 should have been present in response.",entities.contains(newEntity("app","id_4")));
  }
  finally {
    client.destroy();
  }
}

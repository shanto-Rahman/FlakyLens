@Test public void testGetEntitiesByInfoFilters() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app?"+ "infofilters=info2%20eq%203.5");
    ClientResponse resp=getResponse(client,uri);
    Set<TimelineEntity> entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(1,entities.size());
    assertTrue("Entity with id_3 should have been present in response.",entities.contains(newEntity("app","id_3")));
  }
  finally {
    client.destroy();
  }
}

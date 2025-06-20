@Test public void testGetEntitiesByMetricFilters() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app?"+ "metricfilters=metric3%20ge%200");
    ClientResponse resp=getResponse(client,uri);
    Set<TimelineEntity> entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(2,entities.size());
    assertTrue("Entities with id_1 and id_2 should have been present" + " in response.",entities.contains(newEntity("app","id_1")) && entities.contains(newEntity("app","id_2")));
  }
  finally {
    client.destroy();
  }
}

@Test public void testGetEntitiesNoMatch() throws Exception {
  Client client=createClient();
  try {
    URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/"+ "timeline/clusters/cluster1/apps/app1/entities/app?"+ "metricfilters=metric7%20ge%200&isrelatedto=type1:tid1_1:tid1_2,"+ "type2:tid2_1%60&relatesto=flow:flow1&eventfilters=event_2,event_4"+ "&infofilters=info2%20eq%203.5&createdtimestart=1425016502030&"+ "createdtimeend=1425016502060");
    ClientResponse resp=getResponse(client,uri);
    Set<TimelineEntity> entities=resp.getEntity(new GenericType<Set<TimelineEntity>>(){
    }
);
    assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
    assertNotNull(entities);
    assertEquals(0,entities.size());
  }
  finally {
    client.destroy();
  }
}

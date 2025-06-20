@Test public void testGetContainers() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(3,totalEntities);
assertTrue("Entity with container_1_1 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_1_1")));
assertTrue("Entity with container_2_1 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_2_1")));
assertTrue("Entity with container_2_2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_2_2")));
assertEquals(MediaType.APPLICATION_JSON_TYPE,resp.getType());
assertNotNull(entities);
assertEquals(1,retrievedEntity);
assertTrue("Entity with container_1_1 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_1_1")));
assertEquals(MediaType.APPLICATION_JSON_TYPE,resp.getType());
assertNotNull(entities);
assertEquals(2,entities.size());
assertTrue("Entity with container_2_1 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_2_1")));
assertTrue("Entity with container_2_2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_CONTAINER.toString(),"container_2_2")));
assertEquals(totalEntities,retrievedEntity);
}
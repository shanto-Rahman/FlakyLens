@Test public void testGetAppAttempts() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(2,totalEntities);
assertTrue("Entity with app-attempt-2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_APPLICATION_ATTEMPT.toString(),"app-attempt-1")));
assertTrue("Entity with app-attempt-2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_APPLICATION_ATTEMPT.toString(),"app-attempt-2")));
assertEquals(MediaType.APPLICATION_JSON_TYPE,resp.getType());
assertNotNull(entities);
assertEquals(2,retrievedEntity);
assertTrue("Entity with app-attempt-2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_APPLICATION_ATTEMPT.toString(),"app-attempt-1")));
assertTrue("Entity with app-attempt-2 should have been present in response.",entities.contains(newEntity(TimelineEntityType.YARN_APPLICATION_ATTEMPT.toString(),"app-attempt-2")));
assertEquals(totalEntities,retrievedEntity);
}
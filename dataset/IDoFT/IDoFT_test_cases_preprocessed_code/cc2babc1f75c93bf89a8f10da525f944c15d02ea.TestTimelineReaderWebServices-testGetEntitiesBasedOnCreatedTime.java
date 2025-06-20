@Test public void testGetEntitiesBasedOnCreatedTime() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(1,entities.size());
assertTrue("Entity with id_4 should have been present in response.",entities.contains(newEntity("app","id_4")));
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(3,entities.size());
assertFalse("Entity with id_4 should not have been present in response.",entities.contains(newEntity("app","id_4")));
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(1,entities.size());
assertTrue("Entity with id_4 should have been present in response.",entities.contains(newEntity("app","id_4")));
}
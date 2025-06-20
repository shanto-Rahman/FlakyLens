@Test public void testGetEntitiesByInfoFilters() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(1,entities.size());
assertTrue("Entity with id_3 should have been present in response.",entities.contains(newEntity("app","id_3")));
}
@Test public void testGetEntitiesByMetricFilters() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(2,entities.size());
assertTrue("Entities with id_1 and id_2 should have been present" + " in response.",entities.contains(newEntity("app","id_1")) && entities.contains(newEntity("app","id_2")));
}
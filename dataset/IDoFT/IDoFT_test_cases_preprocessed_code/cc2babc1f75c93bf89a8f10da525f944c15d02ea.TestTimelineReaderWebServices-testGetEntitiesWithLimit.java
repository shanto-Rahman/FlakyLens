@Test public void testGetEntitiesWithLimit() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(2,entities.size());
assertTrue("Entities with id_1 and id_4 should have been present " + "in response based on entity created time.",entities.contains(newEntity("app","id_1")) && entities.contains(newEntity("app","id_4")));
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(3,entities.size());
}
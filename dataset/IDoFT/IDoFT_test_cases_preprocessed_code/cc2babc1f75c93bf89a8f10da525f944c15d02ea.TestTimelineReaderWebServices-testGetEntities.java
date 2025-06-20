@Test public void testGetEntities() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(4,entities.size());
assertTrue("Entities id_1, id_2, id_3 and id_4 should have been" + " present in response",entities.contains(newEntity("app","id_1")) && entities.contains(newEntity("app","id_2")) && entities.contains(newEntity("app","id_3"))&& entities.contains(newEntity("app","id_4")));
}
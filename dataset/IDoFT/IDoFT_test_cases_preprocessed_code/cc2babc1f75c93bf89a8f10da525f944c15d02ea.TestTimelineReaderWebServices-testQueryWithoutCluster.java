@Test public void testQueryWithoutCluster() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entity);
assertEquals("id_1",entity.getId());
assertEquals("app",entity.getType());
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities);
assertEquals(4,entities.size());
}
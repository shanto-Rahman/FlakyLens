@Test public void testGetEntityWithUserAndFlowInfo() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entity);
assertEquals("id_1",entity.getId());
assertEquals("app",entity.getType());
assertEquals((Long)1425016502000L,entity.getCreatedTime());
}
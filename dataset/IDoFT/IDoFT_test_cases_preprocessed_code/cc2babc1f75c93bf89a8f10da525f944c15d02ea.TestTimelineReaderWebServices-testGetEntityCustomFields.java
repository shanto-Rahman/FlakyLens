@Test public void testGetEntityCustomFields() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entity);
assertEquals("id_1",entity.getId());
assertEquals("app",entity.getType());
assertEquals(3,entity.getConfigs().size());
assertEquals(3,entity.getMetrics().size());
assertTrue("UID should be present",entity.getInfo().containsKey(TimelineReaderUtils.UID_KEY));
assertEquals(3,entity.getInfo().size());
assertEquals(0,entity.getEvents().size());
}
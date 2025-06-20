@Test public void testGetContainer() throws Exception {
assertEquals(MediaType.APPLICATION_JSON + "; " + JettyUtils.UTF_8,resp.getType().toString());
assertNotNull(entities1);
assertEquals(MediaType.APPLICATION_JSON_TYPE,resp.getType());
assertNotNull(entities2);
assertEquals(entities1,entities2);
}
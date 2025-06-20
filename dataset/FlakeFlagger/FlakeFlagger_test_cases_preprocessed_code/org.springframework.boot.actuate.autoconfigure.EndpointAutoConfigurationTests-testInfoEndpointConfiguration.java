@Test public void testInfoEndpointConfiguration() throws Exception {
assertNotNull(endpoint);
assertNotNull(endpoint.invoke().get("git"));
assertEquals("bar",endpoint.invoke().get("foo"));
}
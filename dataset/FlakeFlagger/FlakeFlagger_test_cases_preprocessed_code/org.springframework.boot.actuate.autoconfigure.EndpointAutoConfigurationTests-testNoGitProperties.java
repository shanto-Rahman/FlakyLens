@Test public void testNoGitProperties() throws Exception {
assertNotNull(endpoint);
assertNull(endpoint.invoke().get("git"));
}
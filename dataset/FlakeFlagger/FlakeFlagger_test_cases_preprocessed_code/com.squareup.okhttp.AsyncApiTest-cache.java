@Test public void cache() throws Exception {
assertNull(server.takeRequest().getHeader("If-None-Match"));
assertEquals("v1",server.takeRequest().getHeader("If-None-Match"));
}
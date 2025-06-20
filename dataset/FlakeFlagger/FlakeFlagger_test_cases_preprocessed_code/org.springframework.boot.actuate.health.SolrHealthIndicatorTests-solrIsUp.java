@Test public void solrIsUp() throws Exception {
assertEquals(Status.UP,health.getStatus());
assertEquals("OK",health.getDetails().get("solrStatus"));
}
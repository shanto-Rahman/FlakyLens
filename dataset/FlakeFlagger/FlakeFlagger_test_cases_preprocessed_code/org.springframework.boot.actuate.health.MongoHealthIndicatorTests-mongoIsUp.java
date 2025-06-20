@Test public void mongoIsUp() throws Exception {
assertEquals(Status.UP,health.getStatus());
assertEquals("2.6.4",health.getDetails().get("version"));
}
@Test public void redisIsUp() throws Exception {
assertEquals(Status.UP,health.getStatus());
assertEquals("2.8.9",health.getDetails().get("version"));
}
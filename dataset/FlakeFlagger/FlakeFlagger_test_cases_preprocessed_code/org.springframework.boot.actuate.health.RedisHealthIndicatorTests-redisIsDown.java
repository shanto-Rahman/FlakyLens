@Test public void redisIsDown() throws Exception {
assertEquals(Status.DOWN,health.getStatus());
assertTrue(((String)health.getDetails().get("error")).contains("Connection failed"));
}
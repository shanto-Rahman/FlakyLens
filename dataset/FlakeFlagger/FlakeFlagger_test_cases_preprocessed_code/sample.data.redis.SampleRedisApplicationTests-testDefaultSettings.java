@Test public void testDefaultSettings() throws Exception {
if (!redisServerRunning(ex)) {
}
assertTrue("Wrong output: " + output,output.contains("Found key spring.boot.redis.test"));
}
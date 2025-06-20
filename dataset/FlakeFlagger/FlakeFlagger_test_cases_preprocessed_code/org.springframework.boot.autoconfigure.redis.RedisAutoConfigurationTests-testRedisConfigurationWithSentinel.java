@Test public void testRedisConfigurationWithSentinel() throws Exception {
if (isAtLeastOneSentinelAvailable(sentinels)) {
assertTrue(this.context.getBean(JedisConnectionFactory.class).isRedisSentinelAware());
}
}
@Test public void testDefaultRedisConfiguration() throws Exception {
assertNotNull(this.context.getBean("redisTemplate",RedisOperations.class));
assertNotNull(this.context.getBean(StringRedisTemplate.class));
}
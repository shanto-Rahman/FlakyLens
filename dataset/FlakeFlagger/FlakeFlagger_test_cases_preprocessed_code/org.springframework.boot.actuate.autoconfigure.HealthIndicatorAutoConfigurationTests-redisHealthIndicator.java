@Test public void redisHealthIndicator(){
assertEquals(1,beans.size());
assertEquals(RedisHealthIndicator.class,beans.values().iterator().next().getClass());
}
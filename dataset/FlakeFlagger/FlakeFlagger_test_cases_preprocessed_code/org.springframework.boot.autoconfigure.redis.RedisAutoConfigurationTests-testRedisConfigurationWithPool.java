@Test public void testRedisConfigurationWithPool() throws Exception {
assertEquals("foo",this.context.getBean(JedisConnectionFactory.class).getHostName());
assertEquals(1,this.context.getBean(JedisConnectionFactory.class).getPoolConfig().getMaxIdle());
}
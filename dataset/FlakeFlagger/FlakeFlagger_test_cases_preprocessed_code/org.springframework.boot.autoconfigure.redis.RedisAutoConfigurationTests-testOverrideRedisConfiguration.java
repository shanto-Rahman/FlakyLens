@Test public void testOverrideRedisConfiguration() throws Exception {
assertEquals("foo",this.context.getBean(JedisConnectionFactory.class).getHostName());
assertEquals(1,this.context.getBean(JedisConnectionFactory.class).getDatabase());
}
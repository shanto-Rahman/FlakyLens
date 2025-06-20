@Test public void indicatorExists(){
assertEquals(1,this.context.getBeanNamesForType(RedisConnectionFactory.class).length);
assertNotNull(healthIndicator);
}
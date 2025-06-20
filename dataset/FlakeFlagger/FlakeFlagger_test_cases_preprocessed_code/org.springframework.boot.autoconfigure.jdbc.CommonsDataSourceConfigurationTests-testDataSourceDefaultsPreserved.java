@Test public void testDataSourceDefaultsPreserved() throws Exception {
assertEquals(GenericObjectPool.DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS,ds.getTimeBetweenEvictionRunsMillis());
assertEquals(GenericObjectPool.DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS,ds.getMinEvictableIdleTimeMillis());
assertEquals(GenericObjectPool.DEFAULT_MAX_WAIT,ds.getMaxWait());
}
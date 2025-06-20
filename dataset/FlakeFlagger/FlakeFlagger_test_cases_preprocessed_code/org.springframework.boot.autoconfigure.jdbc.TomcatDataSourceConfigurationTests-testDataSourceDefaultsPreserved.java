@Test public void testDataSourceDefaultsPreserved() throws Exception {
assertEquals(5000,ds.getTimeBetweenEvictionRunsMillis());
assertEquals(60000,ds.getMinEvictableIdleTimeMillis());
assertEquals(30000,ds.getMaxWait());
assertEquals(30000L,ds.getValidationInterval());
}
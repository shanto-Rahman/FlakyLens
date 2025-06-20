@Test public void testDataSourcePropertiesOverridden() throws Exception {
assertEquals("jdbc:foo//bar/spam",ds.getUrl());
assertTrue(ds.isTestWhileIdle());
assertTrue(ds.isTestOnBorrow());
assertTrue(ds.isTestOnReturn());
assertEquals(10000,ds.getTimeBetweenEvictionRunsMillis());
assertEquals(12345,ds.getMinEvictableIdleTimeMillis());
assertEquals(1234,ds.getMaxWait());
assertEquals(9999L,ds.getValidationInterval());
}
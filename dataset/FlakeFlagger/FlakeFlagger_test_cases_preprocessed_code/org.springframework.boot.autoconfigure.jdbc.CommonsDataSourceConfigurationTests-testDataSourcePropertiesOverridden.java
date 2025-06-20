@Test public void testDataSourcePropertiesOverridden() throws Exception {
assertEquals("jdbc:foo//bar/spam",ds.getUrl());
assertTrue(ds.getTestWhileIdle());
assertTrue(ds.getTestOnBorrow());
assertTrue(ds.getTestOnReturn());
assertEquals(10000,ds.getTimeBetweenEvictionRunsMillis());
assertEquals(12345,ds.getMinEvictableIdleTimeMillis());
assertEquals(1234,ds.getMaxWait());
}
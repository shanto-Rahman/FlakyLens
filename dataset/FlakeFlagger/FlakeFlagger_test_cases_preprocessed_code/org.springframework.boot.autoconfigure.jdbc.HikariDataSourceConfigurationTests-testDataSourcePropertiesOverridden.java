@Test public void testDataSourcePropertiesOverridden() throws Exception {
assertEquals("jdbc:foo//bar/spam",ds.getJdbcUrl());
assertEquals(1234,ds.getMaxLifetime());
}
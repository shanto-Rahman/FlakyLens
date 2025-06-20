@Test public void testDataSourceGenericPropertiesOverridden() throws Exception {
assertEquals("org.h2.JDBCDataSource",ds.getDataSourceProperties().getProperty("dataSourceClassName"));
}
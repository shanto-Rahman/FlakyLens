@Test public void testDefaultDataSourceCanBeOverridden() throws Exception {
assertTrue("DataSource is wrong type: " + dataSource,dataSource instanceof BasicDataSource);
}
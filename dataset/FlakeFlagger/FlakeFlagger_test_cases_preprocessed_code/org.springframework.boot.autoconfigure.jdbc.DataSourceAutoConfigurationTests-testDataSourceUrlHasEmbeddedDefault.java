@Test public void testDataSourceUrlHasEmbeddedDefault() throws Exception {
assertNotNull(dataSource.getUrl());
assertNotNull(dataSource.getDriverClassName());
}
@Test public void testNoDataSourceExists() throws Exception {
assertEquals(0,this.context.getBeanNamesForType(DataSource.class).length);
assertEquals(0,this.context.getBeanNamesForType(DataSourceTransactionManager.class).length);
}
@Test public void testDataSourceExists() throws Exception {
assertNotNull(this.context.getBean(DataSource.class));
assertNotNull(this.context.getBean(HikariDataSource.class));
}
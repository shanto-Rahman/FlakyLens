@Test public void testDataSourceExists() throws Exception {
assertNotNull(this.context.getBean(DataSource.class));
}
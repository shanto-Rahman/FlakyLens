@Test public void testDefaultDataSourceExists() throws Exception {
assertNotNull(this.context.getBean(DataSource.class));
}
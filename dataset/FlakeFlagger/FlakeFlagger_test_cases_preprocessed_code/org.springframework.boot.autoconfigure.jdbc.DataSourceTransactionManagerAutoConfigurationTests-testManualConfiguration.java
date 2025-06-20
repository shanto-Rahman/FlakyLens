@Test public void testManualConfiguration() throws Exception {
assertNotNull(this.context.getBean(DataSource.class));
assertNotNull(this.context.getBean(DataSourceTransactionManager.class));
}
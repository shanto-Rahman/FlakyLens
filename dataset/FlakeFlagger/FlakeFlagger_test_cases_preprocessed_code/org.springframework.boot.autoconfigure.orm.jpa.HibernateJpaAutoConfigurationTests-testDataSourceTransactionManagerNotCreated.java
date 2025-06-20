@Test public void testDataSourceTransactionManagerNotCreated() throws Exception {
assertNotNull(this.context.getBean(DataSource.class));
assertTrue(this.context.getBean("transactionManager") instanceof JpaTransactionManager);
}
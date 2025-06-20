@Test public void testEntityManagerCreated() throws Exception {
assertNotNull(this.context.getBean(DataSource.class));
assertNotNull(this.context.getBean(JpaTransactionManager.class));
}
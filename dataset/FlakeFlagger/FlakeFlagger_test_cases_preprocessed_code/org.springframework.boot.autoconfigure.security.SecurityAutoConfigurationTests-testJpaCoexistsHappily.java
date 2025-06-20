@Test public void testJpaCoexistsHappily() throws Exception {
assertNotNull(this.context.getBean(JpaTransactionManager.class));
}
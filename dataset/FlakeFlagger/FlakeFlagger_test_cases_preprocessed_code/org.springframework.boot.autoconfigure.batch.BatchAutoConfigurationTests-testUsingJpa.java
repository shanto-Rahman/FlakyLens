@Test public void testUsingJpa() throws Exception {
assertTrue(transactionManager.toString().contains("JpaTransactionManager"));
assertNotNull(this.context.getBean(EntityManagerFactory.class));
assertNull(this.context.getBean(JobRepository.class).getLastJobExecution("job",new JobParameters()));
}
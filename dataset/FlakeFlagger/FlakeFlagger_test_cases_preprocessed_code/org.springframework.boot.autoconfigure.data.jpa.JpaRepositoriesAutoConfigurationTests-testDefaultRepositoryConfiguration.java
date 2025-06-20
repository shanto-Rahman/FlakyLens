@Test public void testDefaultRepositoryConfiguration() throws Exception {
assertNotNull(this.context.getBean(CityRepository.class));
assertNotNull(this.context.getBean(PlatformTransactionManager.class));
assertNotNull(this.context.getBean(EntityManagerFactory.class));
}
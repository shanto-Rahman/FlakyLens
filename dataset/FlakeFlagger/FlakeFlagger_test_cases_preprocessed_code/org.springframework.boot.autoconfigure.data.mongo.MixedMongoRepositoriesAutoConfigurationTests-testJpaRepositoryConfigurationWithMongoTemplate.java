@Test public void testJpaRepositoryConfigurationWithMongoTemplate() throws Exception {
assertNotNull(this.context.getBean(CityRepository.class));
}
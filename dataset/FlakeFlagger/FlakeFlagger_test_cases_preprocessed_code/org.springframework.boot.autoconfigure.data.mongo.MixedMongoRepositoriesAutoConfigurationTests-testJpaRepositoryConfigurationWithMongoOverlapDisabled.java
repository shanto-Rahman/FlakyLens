@Test public void testJpaRepositoryConfigurationWithMongoOverlapDisabled() throws Exception {
assertNotNull(this.context.getBean(CityRepository.class));
}
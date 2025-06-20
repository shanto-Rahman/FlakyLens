@Test public void testJpaRepositoryConfigurationWithMongoOverlap() throws Exception {
assertNotNull(this.context.getBean(CityRepository.class));
}
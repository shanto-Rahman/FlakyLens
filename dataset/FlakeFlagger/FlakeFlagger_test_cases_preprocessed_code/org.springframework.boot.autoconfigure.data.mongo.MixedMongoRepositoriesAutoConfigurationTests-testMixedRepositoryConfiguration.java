@Test public void testMixedRepositoryConfiguration() throws Exception {
assertNotNull(this.context.getBean(CountryRepository.class));
assertNotNull(this.context.getBean(CityRepository.class));
}
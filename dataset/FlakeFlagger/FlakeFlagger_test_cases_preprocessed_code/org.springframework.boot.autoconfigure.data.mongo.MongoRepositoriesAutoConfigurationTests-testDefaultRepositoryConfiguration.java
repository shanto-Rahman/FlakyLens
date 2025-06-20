@Test public void testDefaultRepositoryConfiguration() throws Exception {
assertNotNull(this.context.getBean(CityRepository.class));
assertThat(mongo,is(instanceOf(MongoClient.class)));
}
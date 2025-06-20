@Test public void testDefaultRepositoryConfiguration() throws Exception {
assertNotNull(this.context.getBean(CityRepository.class));
assertNotNull(this.context.getBean(Client.class));
}
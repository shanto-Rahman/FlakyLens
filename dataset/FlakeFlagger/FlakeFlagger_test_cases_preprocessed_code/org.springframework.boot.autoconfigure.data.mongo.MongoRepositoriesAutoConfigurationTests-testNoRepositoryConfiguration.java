@Test public void testNoRepositoryConfiguration() throws Exception {
assertThat(mongo,is(instanceOf(MongoClient.class)));
}
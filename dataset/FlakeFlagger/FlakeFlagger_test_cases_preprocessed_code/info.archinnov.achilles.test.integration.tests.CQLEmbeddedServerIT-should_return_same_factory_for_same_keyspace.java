@Test public void should_return_same_factory_for_same_keyspace() throws Exception {
assertThat(factory1).isSameAs(factory2);
}
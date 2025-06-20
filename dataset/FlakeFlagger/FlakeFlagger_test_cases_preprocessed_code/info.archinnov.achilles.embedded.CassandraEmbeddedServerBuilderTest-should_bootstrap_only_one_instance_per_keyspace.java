@Test public void should_bootstrap_only_one_instance_per_keyspace() throws Exception {
assertThat(factory1).isNotEqualTo(factory2);
assertThat(factory1).isEqualTo(factory3);
}
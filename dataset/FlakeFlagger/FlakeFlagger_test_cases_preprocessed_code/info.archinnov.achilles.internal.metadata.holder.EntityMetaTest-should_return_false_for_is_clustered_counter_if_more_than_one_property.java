@Test public void should_return_false_for_is_clustered_counter_if_more_than_one_property() throws Exception {
assertThat(entityMeta.isClusteredCounter()).isFalse();
}
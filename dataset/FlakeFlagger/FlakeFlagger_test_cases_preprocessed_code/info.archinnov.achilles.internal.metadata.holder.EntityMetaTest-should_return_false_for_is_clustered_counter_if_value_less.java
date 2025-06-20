@Test public void should_return_false_for_is_clustered_counter_if_value_less() throws Exception {
assertThat(entityMeta.isClusteredCounter()).isFalse();
}
@Test public void should_build_clustered_counter_meta() throws Exception {
assertThat(meta.isClusteredEntity()).isTrue();
assertThat(meta.isClusteredCounter()).isTrue();
}
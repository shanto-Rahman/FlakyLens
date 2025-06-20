@Test public void should_update_proxified_clustered_counter_entity() throws Exception {
assertThat(pmCaptor.getValue()).containsOnly(pm);
}
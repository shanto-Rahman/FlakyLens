@Test public void should_set_value_to_clustered_counter_entity() throws Exception {
assertThat(counterCaptor.getValue().get()).isEqualTo(counterValue);
}
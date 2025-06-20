@Test public void should_override_mapping_on_class_by_mapping_on_field_for_counter_type() throws Exception {
assertThat(counter.get()).isEqualTo(11L);
}
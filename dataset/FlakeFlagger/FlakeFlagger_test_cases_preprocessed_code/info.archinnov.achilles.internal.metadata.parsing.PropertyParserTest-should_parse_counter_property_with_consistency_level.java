@Test public void should_parse_counter_property_with_consistency_level() throws Exception {
assertThat(meta.type()).isEqualTo(PropertyType.COUNTER);
assertThat(meta.getReadConsistencyLevel()).isEqualTo(ONE);
assertThat(meta.getWriteConsistencyLevel()).isEqualTo(ALL);
}
@Test public void should_encode_bound_values_for_enum_type() throws Exception {
assertThat(encoded).hasSize(1);
assertThat(encoded[0]).isEqualTo("COUNTER");
}
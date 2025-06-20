@Test public void should_not_encode_null_value() throws Exception {
assertThat(encoded).hasSize(1);
assertThat(encoded[0]).isEqualTo(null);
}
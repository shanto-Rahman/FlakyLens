@Test public void should_not_encode_null_varargs() throws Exception {
assertThat(encoded).hasSize(0);
}
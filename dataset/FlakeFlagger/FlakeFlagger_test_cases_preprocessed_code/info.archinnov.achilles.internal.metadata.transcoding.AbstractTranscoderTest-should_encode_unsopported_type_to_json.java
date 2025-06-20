@Test public void should_encode_unsopported_type_to_json() throws Exception {
assertThat(actual).isEqualTo("json_bean");
}
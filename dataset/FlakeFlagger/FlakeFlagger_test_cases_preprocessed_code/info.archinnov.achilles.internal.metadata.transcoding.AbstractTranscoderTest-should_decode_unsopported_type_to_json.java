@Test public void should_decode_unsopported_type_to_json() throws Exception {
assertThat(actual).isEqualTo(bean);
}
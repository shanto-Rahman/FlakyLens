@Test public void should_apply_post_load_interceptor_on_typed_query() throws Exception {
assertThat(actual.getLabel()).isEqualTo("postLoad");
}
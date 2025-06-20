@Test public void should_apply_post_load_interceptor_on_slice_query() throws Exception {
assertThat(clusteredEntities.get(0).getValue()).isEqualTo("postLoad");
}
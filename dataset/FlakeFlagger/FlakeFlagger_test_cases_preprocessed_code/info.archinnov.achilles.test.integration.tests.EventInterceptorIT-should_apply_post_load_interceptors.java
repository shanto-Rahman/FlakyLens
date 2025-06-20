@Test public void should_apply_post_load_interceptors() throws Exception {
assertThat(entity.getLabel()).isEqualTo("postLoad");
}
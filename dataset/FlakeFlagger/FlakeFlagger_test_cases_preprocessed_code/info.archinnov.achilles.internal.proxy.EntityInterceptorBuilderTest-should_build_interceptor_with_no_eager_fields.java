@Test public void should_build_interceptor_with_no_eager_fields() throws Exception {
assertThat(interceptor.getEntityOperations()).isSameAs(context);
assertThat(interceptor.getTarget()).isSameAs(entity);
assertThat(interceptor.getPrimaryKey()).isEqualTo(entity.getId());
assertThat(interceptor.getAlreadyLoaded()).isEmpty();
}
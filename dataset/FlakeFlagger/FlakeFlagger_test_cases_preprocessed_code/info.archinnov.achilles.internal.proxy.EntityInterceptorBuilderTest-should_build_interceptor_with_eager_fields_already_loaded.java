@Test public void should_build_interceptor_with_eager_fields_already_loaded() throws Exception {
assertThat(interceptor.getEntityOperations()).isSameAs(context);
assertThat(interceptor.getTarget()).isSameAs(entity);
assertThat(interceptor.getPrimaryKey()).isEqualTo(entity.getId());
assertThat(interceptor.getAlreadyLoaded()).containsOnly(idMeta.getGetter());
}
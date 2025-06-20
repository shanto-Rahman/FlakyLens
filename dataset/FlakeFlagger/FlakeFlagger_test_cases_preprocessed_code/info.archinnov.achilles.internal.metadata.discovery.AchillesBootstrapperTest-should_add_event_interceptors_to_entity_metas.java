@Test public void should_add_event_interceptors_to_entity_metas() throws Exception {
assertThat(metaString.getInterceptors()).contains(stringInterceptor1,stringInterceptor2);
assertThat(metaLong.getInterceptors()).contains(longInterceptor);
}
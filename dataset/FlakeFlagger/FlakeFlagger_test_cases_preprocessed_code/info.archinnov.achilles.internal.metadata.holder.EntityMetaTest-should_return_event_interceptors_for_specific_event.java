@Test public void should_return_event_interceptors_for_specific_event() throws Exception {
assertThat(entityMeta.getInterceptorsForEvent(POST_PERSIST)).containsExactly(postPersistInterceptor);
assertThat(entityMeta.getInterceptorsForEvent(PRE_PERSIST)).containsExactly(prePersistInterceptor);
}
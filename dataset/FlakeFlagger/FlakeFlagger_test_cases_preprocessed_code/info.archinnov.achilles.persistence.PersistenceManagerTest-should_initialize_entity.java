@Test public void should_initialize_entity() throws Exception {
assertThat(actual).isSameAs(entity);
assertThat(options.getConsistencyLevel().isPresent()).isFalse();
assertThat(options.getTtl().isPresent()).isFalse();
assertThat(options.getTimestamp().isPresent()).isFalse();
}
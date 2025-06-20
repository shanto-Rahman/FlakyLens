@Test public void should_persist_with_options() throws Exception {
assertThat(actual).isSameAs(entity);
assertThat(options.getConsistencyLevel().get()).isEqualTo(EACH_QUORUM);
assertThat(options.getTtl().get()).isEqualTo(150);
assertThat(options.getTimestamp().get()).isEqualTo(100L);
}
@Test public void should_refresh_with_consistency() throws Exception {
assertThat(options.getConsistencyLevel().get()).isSameAs(EACH_QUORUM);
assertThat(options.getTtl().isPresent()).isFalse();
assertThat(options.getTimestamp().isPresent()).isFalse();
}
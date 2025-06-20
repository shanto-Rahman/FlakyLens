@Test public void should_refresh() throws Exception {
assertThat(options.getConsistencyLevel().isPresent()).isFalse();
assertThat(options.getTtl().isPresent()).isFalse();
assertThat(options.getTimestamp().isPresent()).isFalse();
}
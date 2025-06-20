@Test public void should_update_with_options() throws Exception {
assertThat(options.getConsistencyLevel().get()).isEqualTo(EACH_QUORUM);
assertThat(options.getTtl().get()).isEqualTo(150);
assertThat(options.getTimestamp().get()).isEqualTo(100L);
}
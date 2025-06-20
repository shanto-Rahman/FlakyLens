@Test public void should_create_options_with_all_parameters() throws Exception {
assertThat(options.getConsistencyLevel().get()).isSameAs(ALL);
assertThat(options.getTtl().get()).isEqualTo(10);
assertThat(options.getTimestamp().get()).isEqualTo(100L);
}
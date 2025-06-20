@Test public void should_duplicate_with_new_consistency_level() throws Exception {
assertThat(newOptions.getConsistencyLevel().get()).isSameAs(LOCAL_QUORUM);
assertThat(newOptions.getTimestamp().get()).isEqualTo(100L);
assertThat(newOptions.getTtl().get()).isEqualTo(10);
}
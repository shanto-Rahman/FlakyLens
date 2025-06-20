@Test public void should_duplicate_with_new_timestamp() throws Exception {
assertThat(newOptions.getTimestamp().get()).isEqualTo(101L);
assertThat(newOptions.getConsistencyLevel().get()).isEqualTo(EACH_QUORUM);
}
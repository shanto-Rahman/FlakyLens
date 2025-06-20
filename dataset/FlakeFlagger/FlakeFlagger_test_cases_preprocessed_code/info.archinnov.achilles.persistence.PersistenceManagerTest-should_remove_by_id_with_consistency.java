@Test public void should_remove_by_id_with_consistency() throws Exception {
assertThat(options.getConsistencyLevel().get()).isSameAs(LOCAL_QUORUM);
assertThat(options.getTtl().isPresent()).isFalse();
assertThat(options.getTimestamp().isPresent()).isFalse();
}
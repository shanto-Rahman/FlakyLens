@Test public void should_duplicate_without_ttl_and_timestamp() throws Exception {
assertThat(newOptions.getConsistencyLevel().get()).isSameAs(EACH_QUORUM);
assertThat(newOptions.getTimestamp().isPresent()).isFalse();
assertThat(newOptions.getTtl().isPresent()).isFalse();
assertThat(newOptions.isIfNotExists()).isTrue();
assertThat(newOptions.hasCasConditions()).isTrue();
assertThat(newOptions.getCASConditions()).containsExactly(CASCondition);
}
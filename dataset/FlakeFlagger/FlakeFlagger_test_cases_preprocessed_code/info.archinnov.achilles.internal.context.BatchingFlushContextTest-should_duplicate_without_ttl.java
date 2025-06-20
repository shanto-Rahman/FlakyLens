@Test public void should_duplicate_without_ttl() throws Exception {
assertThat(duplicate.statementWrappers).containsOnly(bsWrapper);
assertThat(duplicate.consistencyLevel).isSameAs(EACH_QUORUM);
assertThat(duplicate.serialConsistencyLevel.isPresent()).isFalse();
}
@Test public void should_duplicate_with_no_data_but_consistency() throws Exception {
assertThat(newContext.statementWrappers).isEmpty();
assertThat(newContext.eventHolders).isEmpty();
assertThat(newContext.consistencyLevel).isEqualTo(ConsistencyLevel.EACH_QUORUM);
}
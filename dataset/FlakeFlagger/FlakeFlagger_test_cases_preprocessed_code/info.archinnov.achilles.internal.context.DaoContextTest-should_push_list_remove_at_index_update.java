@Test public void should_push_list_remove_at_index_update() throws Exception {
assertThat(statementWrapperCaptor.getValue().getValues()).contains(boundValues);
assertThat(where.getConsistencyLevel()).isEqualTo(com.datastax.driver.core.ConsistencyLevel.EACH_QUORUM);
}
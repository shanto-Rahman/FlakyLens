@Test public void should_push_list_set_at_index_update() throws Exception {
assertThat(statementWrapper.getValues()).contains(boundValues);
assertThat(statementWrapper.getStatement().getConsistencyLevel()).isEqualTo(com.datastax.driver.core.ConsistencyLevel.EACH_QUORUM);
assertThat(statementWrapper.getStatement().getSerialConsistencyLevel()).isEqualTo(com.datastax.driver.core.ConsistencyLevel.LOCAL_SERIAL);
assertThat(where.getConsistencyLevel()).isEqualTo(com.datastax.driver.core.ConsistencyLevel.EACH_QUORUM);
}
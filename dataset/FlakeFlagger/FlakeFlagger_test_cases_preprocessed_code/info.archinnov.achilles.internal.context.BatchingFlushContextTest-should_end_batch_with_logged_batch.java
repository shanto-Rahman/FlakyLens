@Test public void should_end_batch_with_logged_batch() throws Exception {
assertThat(batchCaptor.getAllValues()).hasSize(2);
assertThat(batchStatement1.getConsistencyLevel()).isSameAs(com.datastax.driver.core.ConsistencyLevel.LOCAL_QUORUM);
assertThat(batchStatement1.getSerialConsistencyLevel()).isSameAs(com.datastax.driver.core.ConsistencyLevel.LOCAL_SERIAL);
assertThat(statements1).contains(statement1,statement2);
assertThat(batchStatement2.getConsistencyLevel()).isSameAs(com.datastax.driver.core.ConsistencyLevel.LOCAL_QUORUM);
assertThat(batchStatement2.getSerialConsistencyLevel()).isSameAs(com.datastax.driver.core.ConsistencyLevel.LOCAL_SERIAL);
assertThat(statements2).contains(statement1,statement2);
}
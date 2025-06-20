@Test public void should_get_cql_consistency_level() throws Exception {
assertThat(cqlSliceQuery.getConsistencyLevel()).isEqualTo(com.datastax.driver.core.ConsistencyLevel.LOCAL_QUORUM);
}
@Test public void should_get_default_cql_consistency_level() throws Exception {
assertThat(cqlSliceQuery.getConsistencyLevel()).isEqualTo(com.datastax.driver.core.ConsistencyLevel.EACH_QUORUM);
}
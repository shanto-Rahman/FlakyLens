@Test public void should_prepare_simple_counter_queries() throws Exception {
assertThat(actual.get(INCR)).isSameAs(incrPs);
assertThat(actual.get(DECR)).isSameAs(decrPs);
assertThat(actual.get(SELECT)).isSameAs(selectPs);
assertThat(actual.get(DELETE)).isSameAs(deletePs);
assertThat(queries).hasSize(4);
assertThat(queries.get(0)).isEqualTo("UPDATE " + CQL_COUNTER_TABLE + " SET "+ CQL_COUNTER_VALUE+ "="+ CQL_COUNTER_VALUE+ "+? WHERE "+ CQL_COUNTER_FQCN+ "=? AND "+ CQL_COUNTER_PRIMARY_KEY+ "=? AND "+ CQL_COUNTER_PROPERTY_NAME+ "=?;");
assertThat(queries.get(1)).isEqualTo("UPDATE " + CQL_COUNTER_TABLE + " SET "+ CQL_COUNTER_VALUE+ "="+ CQL_COUNTER_VALUE+ "-? WHERE "+ CQL_COUNTER_FQCN+ "=? AND "+ CQL_COUNTER_PRIMARY_KEY+ "=? AND "+ CQL_COUNTER_PROPERTY_NAME+ "=?;");
assertThat(queries.get(2)).isEqualTo("SELECT " + CQL_COUNTER_VALUE + " FROM "+ CQL_COUNTER_TABLE+ " WHERE "+ CQL_COUNTER_FQCN+ "=? AND "+ CQL_COUNTER_PRIMARY_KEY+ "=? AND "+ CQL_COUNTER_PROPERTY_NAME+ "=?;");
assertThat(queries.get(3)).isEqualTo("DELETE  FROM " + CQL_COUNTER_TABLE + " WHERE "+ CQL_COUNTER_FQCN+ "=? AND "+ CQL_COUNTER_PRIMARY_KEY+ "=? AND "+ CQL_COUNTER_PROPERTY_NAME+ "=?;");
}
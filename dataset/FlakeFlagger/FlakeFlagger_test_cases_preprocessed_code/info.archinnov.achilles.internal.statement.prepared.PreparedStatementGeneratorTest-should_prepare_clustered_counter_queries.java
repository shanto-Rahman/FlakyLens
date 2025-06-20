@Test public void should_prepare_clustered_counter_queries() throws Exception {
assertThat(actual.get(INCR).get("count")).isSameAs(incrPs);
assertThat(actual.get(DECR).get("count")).isSameAs(decrPs);
assertThat(actual.get(SELECT).get("count")).isSameAs(selectPs);
assertThat(actual.get(DELETE).get(DELETE_ALL.name())).isSameAs(deletePs);
assertThat(regularStatements).hasSize(5);
assertThat(regularStatements.get(0).getQueryString()).isEqualTo("UPDATE counterTable USING TTL :ttl SET count=count+:count WHERE id=:id;");
assertThat(regularStatements.get(1).getQueryString()).isEqualTo("UPDATE counterTable USING TTL :ttl SET count=count-:count WHERE id=:id;");
assertThat(regularStatements.get(2).getQueryString()).isEqualTo("SELECT count FROM counterTable WHERE id=:id;");
assertThat(regularStatements.get(3).getQueryString()).isEqualTo("SELECT * FROM counterTable WHERE id=:id;");
assertThat(regularStatements.get(4).getQueryString()).isEqualTo("DELETE  FROM counterTable WHERE id=:id;");
}
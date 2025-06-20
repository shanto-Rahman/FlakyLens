@Test public void should_prepare_insert_ps_with_clustered_id_and_options() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(queryCaptor.getValue()).isEqualTo("INSERT INTO table(id,a,b,name) VALUES (:id,:a,:b,:name) IF NOT EXISTS USING TTL :ttl AND TIMESTAMP :timestamp;");
}
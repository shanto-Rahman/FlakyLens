@Test public void should_prepare_insert_ps() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(queryCaptor.getValue()).isEqualTo("INSERT INTO table(id,name) VALUES (:id,:name) USING TTL :ttl;");
}
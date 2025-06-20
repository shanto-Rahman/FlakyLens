@Test public void should_prepare_update_fields_with_clustered_id_ps() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(queryCaptor.getValue()).isEqualTo("UPDATE table USING TTL :ttl SET name=:name,age=:age WHERE id=:id AND a=:a AND b=:b;");
}
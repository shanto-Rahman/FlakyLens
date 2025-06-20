@Test public void should_prepare_update_fields_ps() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(queryCaptor.getValue()).isEqualTo("UPDATE table USING TTL :ttl AND TIMESTAMP :timestamp SET name=:name,age=:age WHERE id=:id IF name=:name;");
}
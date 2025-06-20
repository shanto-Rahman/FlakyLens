@Test public void should_parse_entity_with_table_name() throws Exception {
assertThat(meta).isNotNull();
assertThat(meta.getTableName()).isEqualTo("myOwnCF");
}
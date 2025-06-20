@Test public void should_persist_and_find_entity_having_compound_id_with_enum() throws Exception {
assertThat(foundCompoundKey.getId()).isEqualTo(id);
assertThat(foundCompoundKey.getType()).isEqualTo(Type.TEXT);
}
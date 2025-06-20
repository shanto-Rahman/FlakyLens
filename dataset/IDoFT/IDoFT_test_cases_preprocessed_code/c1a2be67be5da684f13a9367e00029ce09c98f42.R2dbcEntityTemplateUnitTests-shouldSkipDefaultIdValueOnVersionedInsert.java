@Test void shouldSkipDefaultIdValueOnVersionedInsert(){
assertThat(actual.getVersion()).isEqualTo(1);
assertThat(statement.getSql()).isEqualTo("INSERT INTO versioned_person_with_primitive_id (version, name) VALUES ($1, $2)");
assertThat(statement.getBindings()).hasSize(2).containsEntry(0,Parameter.from(1L)).containsEntry(1,Parameter.from("bar"));
}
@Test void shouldInsertVersioned(){
assertThat(actual.getVersion()).isEqualTo(1);
assertThat(statement.getSql()).isEqualTo("INSERT INTO versioned_person (id, version, name) VALUES ($1, $2, $3)");
assertThat(statement.getBindings()).hasSize(3).containsEntry(0,Parameter.from("id")).containsEntry(1,Parameter.from(1L));
}
@Test void insertShouldInvokeCallback(){
assertThat(actual.id).isEqualTo("after-save");
assertThat(actual.name).isEqualTo("before-convert");
assertThat(actual.description).isNull();
assertThat(statement.getSql()).isEqualTo("INSERT INTO person (THE_NAME, description) VALUES ($1, $2)");
assertThat(statement.getBindings()).hasSize(2).containsEntry(0,Parameter.from("before-convert")).containsEntry(1,Parameter.from("before-save"));
}
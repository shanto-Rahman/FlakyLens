@Test void updateShouldInvokeCallback(){
assertThat(actual.id).isEqualTo("after-save");
assertThat(actual.name).isEqualTo("before-convert");
assertThat(actual.description).isNull();
assertThat(statement.getSql()).isEqualTo("UPDATE person SET THE_NAME = $1, description = $2 WHERE person.id = $3");
assertThat(statement.getBindings()).hasSize(3).containsEntry(0,Parameter.from("before-convert")).containsEntry(1,Parameter.from("before-save"));
}
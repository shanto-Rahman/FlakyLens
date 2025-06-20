@Test void shouldUpdateCorrectlyVersionedAndAudited(){
assertThat(actual.getVersion()).isEqualTo(3);
assertThat(actual.getCreatedDate()).isNull();
assertThat(actual.getLastModifiedDate()).isNotNull();
assertThat(statement.getSql()).startsWith("UPDATE with_auditing_and_optimistic_locking SET version = $1, name = $2, created_date = $3, last_modified_date = $4");
}
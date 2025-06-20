@Test void shouldInsertCorrectlyVersionedAndAudited(){
assertThat(actual.getVersion()).isEqualTo(1);
assertThat(actual.getCreatedDate()).isNotNull();
assertThat(statement.getSql()).isEqualTo("INSERT INTO with_auditing_and_optimistic_locking (version, name, created_date, last_modified_date) VALUES ($1, $2, $3, $4)");
}
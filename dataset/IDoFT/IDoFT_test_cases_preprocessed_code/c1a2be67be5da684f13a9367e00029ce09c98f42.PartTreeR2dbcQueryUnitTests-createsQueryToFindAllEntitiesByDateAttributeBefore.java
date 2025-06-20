@Test void createsQueryToFindAllEntitiesByDateAttributeBefore() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".date_of_birth < $1");
}
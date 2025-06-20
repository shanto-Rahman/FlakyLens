@Test void createsQueryToFindAllEntitiesByOneOfTwoStringAttributes() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".last_name = $1 OR ("+ TABLE+ ".first_name = $2)");
}
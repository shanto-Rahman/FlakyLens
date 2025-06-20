@Test void createsQueryToFindAllEntitiesByOneOfTwoStringAttributes() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".last_name = $1 OR ("+ TABLE+ ".first_name = $2)"));
}
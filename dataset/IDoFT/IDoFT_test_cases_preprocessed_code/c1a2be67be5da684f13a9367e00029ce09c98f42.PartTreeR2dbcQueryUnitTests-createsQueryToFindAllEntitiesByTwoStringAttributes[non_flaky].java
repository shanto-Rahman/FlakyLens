@Test void createsQueryToFindAllEntitiesByTwoStringAttributes() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".last_name = $1 AND ("+ TABLE+ ".first_name = $2)"));
}
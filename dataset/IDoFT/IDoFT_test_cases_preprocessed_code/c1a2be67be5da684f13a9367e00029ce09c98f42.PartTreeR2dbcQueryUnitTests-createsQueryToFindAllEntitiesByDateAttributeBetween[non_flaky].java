@Test void createsQueryToFindAllEntitiesByDateAttributeBetween() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".date_of_birth BETWEEN $1 AND $2"));
}
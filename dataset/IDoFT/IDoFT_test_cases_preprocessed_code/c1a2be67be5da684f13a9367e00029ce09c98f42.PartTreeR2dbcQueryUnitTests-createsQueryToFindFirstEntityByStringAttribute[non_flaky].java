@Test void createsQueryToFindFirstEntityByStringAttribute() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".first_name = $1 LIMIT 1"));
}
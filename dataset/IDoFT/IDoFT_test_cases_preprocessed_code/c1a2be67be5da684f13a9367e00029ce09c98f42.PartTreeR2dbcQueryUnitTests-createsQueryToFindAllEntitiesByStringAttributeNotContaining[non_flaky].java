@Test void createsQueryToFindAllEntitiesByStringAttributeNotContaining() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".first_name NOT LIKE $1"));
}
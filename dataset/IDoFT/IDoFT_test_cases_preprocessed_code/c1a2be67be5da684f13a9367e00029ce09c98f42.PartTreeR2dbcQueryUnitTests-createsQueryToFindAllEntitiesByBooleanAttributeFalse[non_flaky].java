@Test void createsQueryToFindAllEntitiesByBooleanAttributeFalse() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".active = FALSE"));
}
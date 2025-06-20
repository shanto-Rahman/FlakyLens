@Test void createsQueryToFindAllEntitiesByIntegerAttributeNotIn() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".age NOT IN ($1)"));
}
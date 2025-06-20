@Test void createsQueryToFindAllEntitiesByIntegerAttributeIsNotNull() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".age IS NOT NULL"));
}
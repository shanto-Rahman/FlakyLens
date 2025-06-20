@Test void createsQueryToFindAllEntitiesByBooleanAttributeTrue() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".active = TRUE"));
}
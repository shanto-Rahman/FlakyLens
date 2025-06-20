@Test void createsQueryToFindAllEntitiesByIntegerAttributeIsNotNull() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".age IS NOT NULL");
}
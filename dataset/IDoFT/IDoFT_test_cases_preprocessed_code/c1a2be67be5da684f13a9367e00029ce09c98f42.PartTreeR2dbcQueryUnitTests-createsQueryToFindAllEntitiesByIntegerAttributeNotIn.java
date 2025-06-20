@Test void createsQueryToFindAllEntitiesByIntegerAttributeNotIn() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".age NOT IN ($1)");
}
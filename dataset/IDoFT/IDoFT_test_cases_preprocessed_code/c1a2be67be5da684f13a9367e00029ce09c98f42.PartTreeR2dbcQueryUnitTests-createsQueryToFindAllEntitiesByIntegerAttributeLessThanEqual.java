@Test void createsQueryToFindAllEntitiesByIntegerAttributeLessThanEqual() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".age <= $1");
}
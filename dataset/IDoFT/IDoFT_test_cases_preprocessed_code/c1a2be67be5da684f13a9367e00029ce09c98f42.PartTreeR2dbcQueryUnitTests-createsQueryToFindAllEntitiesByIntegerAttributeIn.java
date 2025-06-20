@Test void createsQueryToFindAllEntitiesByIntegerAttributeIn() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".age IN ($1)");
}
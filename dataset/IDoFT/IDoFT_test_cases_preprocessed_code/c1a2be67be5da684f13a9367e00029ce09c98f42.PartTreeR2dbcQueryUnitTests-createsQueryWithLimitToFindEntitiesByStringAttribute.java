@Test void createsQueryWithLimitToFindEntitiesByStringAttribute() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".first_name = $1 LIMIT 3");
}
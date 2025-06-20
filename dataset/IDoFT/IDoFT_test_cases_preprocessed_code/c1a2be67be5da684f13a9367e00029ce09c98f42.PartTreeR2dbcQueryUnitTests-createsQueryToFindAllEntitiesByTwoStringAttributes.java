@Test void createsQueryToFindAllEntitiesByTwoStringAttributes() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".last_name = $1 AND ("+ TABLE+ ".first_name = $2)");
}
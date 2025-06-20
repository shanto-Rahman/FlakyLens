@Test void createsQueryToFindAllEntitiesByStringAttributeIgnoringCase() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE UPPER("+ TABLE+ ".first_name) = UPPER($1)");
}
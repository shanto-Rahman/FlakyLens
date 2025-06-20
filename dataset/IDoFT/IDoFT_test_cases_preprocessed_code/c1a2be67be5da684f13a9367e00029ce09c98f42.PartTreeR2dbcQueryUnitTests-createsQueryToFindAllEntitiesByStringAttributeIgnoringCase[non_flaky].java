@Test void createsQueryToFindAllEntitiesByStringAttributeIgnoringCase() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE UPPER("+ TABLE+ ".first_name) = UPPER($1)"));
}
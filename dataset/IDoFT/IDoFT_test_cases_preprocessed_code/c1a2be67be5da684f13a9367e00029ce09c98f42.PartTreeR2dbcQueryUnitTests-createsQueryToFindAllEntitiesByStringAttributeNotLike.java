@Test void createsQueryToFindAllEntitiesByStringAttributeNotLike() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".first_name NOT LIKE $1");
}
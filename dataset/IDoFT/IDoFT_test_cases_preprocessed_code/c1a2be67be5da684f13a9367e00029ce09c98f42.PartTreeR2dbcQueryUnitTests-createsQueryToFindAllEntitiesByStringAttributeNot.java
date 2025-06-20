@Test void createsQueryToFindAllEntitiesByStringAttributeNot() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".last_name != $1");
}
@Test void createsQueryToFindAllEntitiesByBooleanAttributeTrue() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".active = TRUE");
}
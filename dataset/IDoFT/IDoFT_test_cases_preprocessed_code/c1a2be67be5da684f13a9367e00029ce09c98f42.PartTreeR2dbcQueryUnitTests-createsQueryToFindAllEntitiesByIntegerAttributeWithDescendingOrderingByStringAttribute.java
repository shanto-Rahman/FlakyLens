@Test void createsQueryToFindAllEntitiesByIntegerAttributeWithDescendingOrderingByStringAttribute() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".age = $1 ORDER BY users.last_name DESC");
}
@Test void createsQueryWithIsNullCondition() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".first_name IS NULL");
}
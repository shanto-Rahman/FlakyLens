@Test void createsDtoProjectionQuery() throws Exception {
assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT users.id, users.first_name, users.last_name, users.date_of_birth, users.age, users.active FROM " + TABLE));
}
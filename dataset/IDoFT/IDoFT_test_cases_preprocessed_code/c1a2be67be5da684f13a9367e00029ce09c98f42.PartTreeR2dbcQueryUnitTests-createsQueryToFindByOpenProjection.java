@Test void createsQueryToFindByOpenProjection() throws Exception {
assertThat(preparedOperation.get()).isEqualTo("SELECT users.id, users.first_name, users.last_name, users.date_of_birth, users.age, users.active FROM " + TABLE);
}
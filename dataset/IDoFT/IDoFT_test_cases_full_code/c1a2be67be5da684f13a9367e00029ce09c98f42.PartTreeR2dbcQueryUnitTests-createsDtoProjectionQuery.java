@Test void createsDtoProjectionQuery() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAsDtoProjectionBy");
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  PreparedOperation<?> preparedOperation=createQuery(queryMethod,r2dbcQuery);
  assertThat(preparedOperation.get()).isEqualTo("SELECT users.id, users.first_name, users.last_name, users.date_of_birth, users.age, users.active FROM " + TABLE);
}

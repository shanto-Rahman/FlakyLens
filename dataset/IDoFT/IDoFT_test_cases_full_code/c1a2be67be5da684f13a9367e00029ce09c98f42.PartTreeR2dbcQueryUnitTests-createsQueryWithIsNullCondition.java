@Test void createsQueryWithIsNullCondition() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByFirstName",String.class);
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  PreparedOperation<?> preparedOperation=createQuery(queryMethod,r2dbcQuery,new Object[]{null});
  assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".first_name IS NULL");
}

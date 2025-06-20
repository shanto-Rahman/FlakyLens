@Test void createsQueryToFindAllEntitiesByOneOfTwoStringAttributes() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByLastNameOrFirstName",String.class,String.class);
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  PreparedOperation<?> preparedOperation=createQuery(r2dbcQuery,getAccessor(queryMethod,new Object[]{"Doe","John"}));
  assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".last_name = $1 OR ("+ TABLE+ ".first_name = $2)");
}

@Test void createsQueryToFindAllEntitiesByStringAttributeNot() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByLastNameNot",String.class);
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  RelationalParametersParameterAccessor accessor=getAccessor(queryMethod,new Object[]{"Doe"});
  PreparedOperation<?> preparedOperation=createQuery(r2dbcQuery,accessor);
  assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".last_name != $1");
}

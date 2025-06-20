@Test void createsQueryToFindAllEntitiesByIntegerAttributeGreaterThanEqual() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByAgeGreaterThanEqual",Integer.class);
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  RelationalParametersParameterAccessor accessor=getAccessor(queryMethod,new Object[]{30});
  PreparedOperation<?> preparedOperation=createQuery(r2dbcQuery,accessor);
  assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".age >= $1");
}

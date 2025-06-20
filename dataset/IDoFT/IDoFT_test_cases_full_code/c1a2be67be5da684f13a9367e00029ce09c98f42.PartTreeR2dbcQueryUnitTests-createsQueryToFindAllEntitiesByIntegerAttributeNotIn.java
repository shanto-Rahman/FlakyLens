@Test void createsQueryToFindAllEntitiesByIntegerAttributeNotIn() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByAgeNotIn",Collection.class);
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  RelationalParametersParameterAccessor accessor=getAccessor(queryMethod,new Object[]{Collections.singleton(25)});
  PreparedOperation<?> preparedOperation=createQuery(r2dbcQuery,accessor);
  assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".age NOT IN ($1)");
}

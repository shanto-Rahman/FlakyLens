@Test void createsQueryToFindAllEntitiesByBooleanAttributeTrue() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByActiveTrue");
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  RelationalParametersParameterAccessor accessor=getAccessor(queryMethod,new Object[0]);
  PreparedOperation<?> preparedOperation=createQuery(r2dbcQuery,accessor);
  assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".active = TRUE"));
}

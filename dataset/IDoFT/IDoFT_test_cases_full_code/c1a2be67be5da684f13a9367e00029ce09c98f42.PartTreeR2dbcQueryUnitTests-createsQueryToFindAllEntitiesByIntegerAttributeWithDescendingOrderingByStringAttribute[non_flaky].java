@Test void createsQueryToFindAllEntitiesByIntegerAttributeWithDescendingOrderingByStringAttribute() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByAgeOrderByLastNameDesc",Integer.class);
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  RelationalParametersParameterAccessor accessor=getAccessor(queryMethod,new Object[]{"oh"});
  PreparedOperation<?> preparedOperation=createQuery(r2dbcQuery,accessor);
  assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".age = $1 ORDER BY users.last_name DESC"));
}

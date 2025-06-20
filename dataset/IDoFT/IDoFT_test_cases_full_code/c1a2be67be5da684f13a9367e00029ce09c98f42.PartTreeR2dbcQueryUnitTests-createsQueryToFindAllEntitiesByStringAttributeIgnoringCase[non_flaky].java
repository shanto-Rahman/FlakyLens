@Test void createsQueryToFindAllEntitiesByStringAttributeIgnoringCase() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByFirstNameIgnoreCase",String.class);
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  RelationalParametersParameterAccessor accessor=getAccessor(queryMethod,new Object[]{"John"});
  PreparedOperation<?> preparedOperation=createQuery(r2dbcQuery,accessor);
  assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE UPPER("+ TABLE+ ".first_name) = UPPER($1)"));
}

@Test void createsQueryToFindAllEntitiesByStringAttributeEndingWith() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByFirstNameEndingWith",String.class);
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  RelationalParametersParameterAccessor accessor=getAccessor(queryMethod,new Object[]{"hn"});
  PreparedOperation<?> preparedOperation=createQuery(r2dbcQuery,accessor);
  assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".first_name LIKE $1"));
}

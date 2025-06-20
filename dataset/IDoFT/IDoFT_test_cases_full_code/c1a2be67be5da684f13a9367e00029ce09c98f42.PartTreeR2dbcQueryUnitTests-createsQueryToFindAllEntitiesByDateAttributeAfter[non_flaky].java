@Test void createsQueryToFindAllEntitiesByDateAttributeAfter() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByDateOfBirthAfter",Date.class);
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  RelationalParametersParameterAccessor accessor=getAccessor(queryMethod,new Object[]{new Date()});
  PreparedOperation<?> preparedOperation=createQuery(r2dbcQuery,accessor);
  assertThat(formatOperation(preparedOperation)).isEqualTo(formatQuery("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".date_of_birth > $1"));
}

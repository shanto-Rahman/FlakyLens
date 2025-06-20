@Test void createsQueryToFindAllEntitiesByDateAttributeBetween() throws Exception {
  R2dbcQueryMethod queryMethod=getQueryMethod("findAllByDateOfBirthBetween",Date.class,Date.class);
  PartTreeR2dbcQuery r2dbcQuery=new PartTreeR2dbcQuery(queryMethod,operations,r2dbcConverter,dataAccessStrategy);
  Date from=new Date();
  Date to=new Date();
  RelationalParametersParameterAccessor accessor=getAccessor(queryMethod,new Object[]{from,to});
  PreparedOperation<?> preparedOperation=createQuery(r2dbcQuery,accessor);
  assertThat(preparedOperation.get()).isEqualTo("SELECT " + ALL_FIELDS + " FROM "+ TABLE+ " WHERE "+ TABLE+ ".date_of_birth BETWEEN $1 AND $2");
  BindTarget bindTarget=mock(BindTarget.class);
  preparedOperation.bindTo(bindTarget);
  verify(bindTarget,times(1)).bind(0,from);
  verify(bindTarget,times(1)).bind(1,to);
}

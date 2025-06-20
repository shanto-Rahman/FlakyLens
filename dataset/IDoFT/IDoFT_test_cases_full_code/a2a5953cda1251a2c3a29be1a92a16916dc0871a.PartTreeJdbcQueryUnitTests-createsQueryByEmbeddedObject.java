@Test public void createsQueryByEmbeddedObject() throws Exception {
  JdbcQueryMethod queryMethod=getQueryMethod("findByAddress",Address.class);
  PartTreeJdbcQuery jdbcQuery=createQuery(queryMethod);
  RelationalParametersParameterAccessor accessor=getAccessor(queryMethod,new Object[]{new Address("Hello","World")});
  ParametrizedQuery query=jdbcQuery.createQuery(accessor,returnedType);
  String expectedSql=BASE_SELECT + " WHERE (" + TABLE+ ".\"USER_STREET\" = :user_street AND "+ TABLE+ ".\"USER_CITY\" = :user_city)";
  assertThat(query.getQuery()).isEqualTo(expectedSql);
  assertThat(query.getParameterSource().getValue("user_street")).isEqualTo("Hello");
  assertThat(query.getParameterSource().getValue("user_city")).isEqualTo("World");
}

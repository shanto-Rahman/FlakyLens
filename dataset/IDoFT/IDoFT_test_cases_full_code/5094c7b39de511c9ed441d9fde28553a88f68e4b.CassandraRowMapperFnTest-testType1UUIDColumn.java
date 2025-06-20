@Test public void testType1UUIDColumn(){
  String value=com.datastax.driver.core.utils.UUIDs.timeBased().toString();
  primeWithType(value,UUID);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.STRING).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

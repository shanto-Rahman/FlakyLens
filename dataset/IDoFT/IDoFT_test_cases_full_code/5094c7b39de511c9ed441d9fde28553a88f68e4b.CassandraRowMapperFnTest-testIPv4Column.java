@Test public void testIPv4Column(){
  String value="10.10.10.10";
  primeWithType(value,INET);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.STRING).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

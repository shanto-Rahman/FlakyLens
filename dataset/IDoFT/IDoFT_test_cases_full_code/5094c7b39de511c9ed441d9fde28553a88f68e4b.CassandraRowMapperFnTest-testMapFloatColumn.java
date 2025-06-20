@Test public void testMapFloatColumn(){
  Float value=123.4f;
  primeWithType(value,FLOAT);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.FLOAT).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

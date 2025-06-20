@Test public void testMapBooleanColumn(){
  Boolean value=Boolean.FALSE;
  primeWithType(value,BOOLEAN);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.BOOLEAN).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

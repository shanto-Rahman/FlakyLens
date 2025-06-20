@Test public void testMapDoubleColumn(){
  Double value=Double.MIN_VALUE;
  primeWithType(value,DOUBLE);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.DOUBLE).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

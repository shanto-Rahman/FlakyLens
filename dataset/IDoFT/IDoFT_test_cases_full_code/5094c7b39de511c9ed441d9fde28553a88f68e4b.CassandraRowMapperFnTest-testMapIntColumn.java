@Test public void testMapIntColumn(){
  Integer value=12355;
  primeWithType(value,INT);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.INT32).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

@Test public void testSmallIntColumn(){
  Short value=Short.MAX_VALUE;
  primeWithType(value,SMALL_INT);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.INT16).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

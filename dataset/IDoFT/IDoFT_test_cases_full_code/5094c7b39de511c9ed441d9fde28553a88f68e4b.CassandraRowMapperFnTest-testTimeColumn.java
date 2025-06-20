@Test public void testTimeColumn(){
  LocalTime now=LocalTime.now(ZoneId.systemDefault());
  Long value=now.toNanoOfDay();
  primeWithType(value,TIME);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.INT64).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

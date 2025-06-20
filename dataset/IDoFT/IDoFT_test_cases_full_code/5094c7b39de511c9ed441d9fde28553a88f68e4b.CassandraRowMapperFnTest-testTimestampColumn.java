@Test public void testTimestampColumn(){
  Long value=System.currentTimeMillis();
  primeWithType(value,TIMESTAMP);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.DATETIME).build();
  Row expected=Row.withSchema(schema).addValue(new DateTime(value)).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

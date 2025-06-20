@Test public void testMapBigIntColumn(){
  BigInteger value=BigInteger.TEN;
  primeWithType(value,BIG_INT);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.INT64).build();
  Row expected=Row.withSchema(schema).addValue(value.longValue()).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

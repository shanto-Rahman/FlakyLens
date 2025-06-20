@Test public void testDecimalColumn(){
  BigDecimal value=new BigDecimal(0.6);
  primeWithType(value,DECIMAL);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.DECIMAL).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

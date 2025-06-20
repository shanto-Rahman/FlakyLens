@Test public void testVarIntColumn(){
  BigInteger value=new BigInteger(32,new Random());
  primeWithType(value,VAR_INT);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.DECIMAL).build();
  Row expected=Row.withSchema(schema).addValue(new BigDecimal(value)).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

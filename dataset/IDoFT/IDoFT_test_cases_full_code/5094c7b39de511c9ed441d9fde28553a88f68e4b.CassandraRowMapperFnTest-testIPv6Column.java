@Test public void testIPv6Column(){
  String value=InetAddresses.fromInteger(new Random().nextInt()).getHostAddress();
  primeWithType(value,INET);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.STRING).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

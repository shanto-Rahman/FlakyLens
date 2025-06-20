@Test public void testASCIIColumn(){
  String s="Hello world";
  primeWithType(s,ASCII);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.STRING).build();
  Row expected=Row.withSchema(schema).addValue(s).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

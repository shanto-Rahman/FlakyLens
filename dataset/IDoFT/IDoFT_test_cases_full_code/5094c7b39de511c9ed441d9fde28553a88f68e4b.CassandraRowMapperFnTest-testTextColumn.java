@Test public void testTextColumn(){
  String value="Hello world!";
  primeWithType(value,TEXT);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.STRING).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  Row next=cassandraRowMapper.map(resultSet).next();
  assertEquals(expected,next);
}

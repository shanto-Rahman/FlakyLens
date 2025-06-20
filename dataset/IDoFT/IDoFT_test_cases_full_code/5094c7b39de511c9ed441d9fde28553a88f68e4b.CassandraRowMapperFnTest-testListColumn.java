@Test public void testListColumn(){
  ArrayList<String> value=new ArrayList<>();
  value.add("Hello");
  value.add("world!");
  primeWithType(value,list(VARCHAR));
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.array(FieldType.STRING)).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

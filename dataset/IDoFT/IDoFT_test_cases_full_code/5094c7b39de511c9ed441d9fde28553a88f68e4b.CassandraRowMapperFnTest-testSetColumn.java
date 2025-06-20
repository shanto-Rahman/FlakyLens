@Test public void testSetColumn(){
  Set<Integer> value=new HashSet<>();
  value.add(1);
  value.add(2);
  primeWithType(value,set(INT));
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.array(FieldType.INT32)).build();
  Row expected=Row.withSchema(schema).addValue(new ArrayList<>(value)).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

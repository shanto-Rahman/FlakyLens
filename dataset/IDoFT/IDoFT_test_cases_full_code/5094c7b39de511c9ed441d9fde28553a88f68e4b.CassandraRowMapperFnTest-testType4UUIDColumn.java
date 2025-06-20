@Test public void testType4UUIDColumn(){
  UUID value=java.util.UUID.randomUUID();
  primeWithType(value,UUID);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.STRING).build();
  Row expected=Row.withSchema(schema).addValue(value.toString()).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

@Test public void testMapBlobColumn(){
  byte[] value=new byte[20];
  new Random().nextBytes(value);
  primeWithType(Hex.encodeHexString(value),BLOB);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.BYTES).build();
  Row expected=Row.withSchema(schema).addValue(value).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}

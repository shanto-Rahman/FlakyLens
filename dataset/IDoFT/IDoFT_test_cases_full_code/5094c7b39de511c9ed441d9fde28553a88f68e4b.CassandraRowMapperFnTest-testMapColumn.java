@Test public void testMapColumn(){
  Map<String,UUID> cassandraInsert=new HashMap<>();
  UUID uuid1=java.util.UUID.randomUUID();
  UUID uuid2=java.util.UUID.randomUUID();
  cassandraInsert.put("1",uuid1);
  cassandraInsert.put("2",uuid2);
  Map<String,String> beamValue=new HashMap<>();
  beamValue.put("1",uuid1.toString());
  beamValue.put("2",uuid2.toString());
  primeWithType(cassandraInsert,MapType.map(VARCHAR,UUID));
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.map(FieldType.STRING,FieldType.STRING)).build();
  Row expected=Row.withSchema(schema).addValue(beamValue).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}
